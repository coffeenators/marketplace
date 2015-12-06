package com.msquared;

import com.simplify.payments.PaymentsApi;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Payment;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by S on 12/5/15.
 */
@Component
@Path("/feedMe")
@Produces(MediaType.APPLICATION_JSON)
public class FeedMe implements HouseService  {

    @Override
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
                .set("amount", 2500) // In cents e.g. $10.00
                .set("description", "Feed Me");

        Payment payment = Payment.create(paymentsMap);

        if ("APPROVED".equals(payment.get("paymentStatus"))) {
            System.out.println("Payment approved");
            response.setServiceStatus("Bon Appetit!");
        }

        response.setServiceStatus("Stay Hungry my friend!");

        return Response.ok() //200
                .entity(response)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type")
                .allow("OPTIONS").build();
    }
}
