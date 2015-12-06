package com.msquared;

import com.simplify.payments.PaymentsApi;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Payment;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Map;

@Component
@Path("/hitchARide")
public class HitchARide implements HouseService {

    @GET
    public Response serveMe() throws Exception {

        PaymentsApi.PRIVATE_KEY = "chc5J5yNW2uMTJE+McIsHXK08TUy1DCgjNzDwCS8mZd5YFFQL0ODSXAOkNtXTToq";
        PaymentsApi.PUBLIC_KEY = "sbpb_OTQ5YjczMTQtMmQzNy00ZGIwLWExZDgtMzY0ZGQ5ODcxNjNh";
        MSquaredResponse response = new MSquaredResponse();


        Map paymentsMap = new PaymentsMap()
                .set("currency", "USD")
                .set("card.cvc", "123")
                .set("card.expMonth", 11)
                .set("card.expYear", 19)
                .set("card.number", "5555555555554444")
                .set("amount", 1000) // In cents e.g. $10.00
                .set("description", "Hitching a ride");

        Payment payment = Payment.create(paymentsMap);

        if ("APPROVED".equals(payment.get("paymentStatus"))) {
            System.out.println("Payment approved");
            response.setServiceStatus("Hitched!");

        }

        response.setServiceStatus("Get a hike!");

        return Response.ok() //200
                .entity(response)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type")
                .allow("OPTIONS").build();
    }
}
