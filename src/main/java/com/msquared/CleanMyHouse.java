package com.msquared;

import com.simplify.payments.PaymentsApi;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Payment;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Path("/cleanMyHouse")
@Produces(MediaType.APPLICATION_JSON)
public class CleanMyHouse {

 @GET
  public boolean cleanMyHouse() throws Exception {

        PaymentsApi.PRIVATE_KEY = "chc5J5yNW2uMTJE+McIsHXK08TUy1DCgjNzDwCS8mZd5YFFQL0ODSXAOkNtXTToq";
        PaymentsApi.PUBLIC_KEY = "sbpb_OTQ5YjczMTQtMmQzNy00ZGIwLWExZDgtMzY0ZGQ5ODcxNjNh";
        Map paymentsMap = new PaymentsMap()
                .set("currency", "USD")
                .set("card.cvc", "123")
                .set("card.expMonth", 11)
                .set("card.expYear", 19)
                .set("card.number", "5555555555554444")
                .set("amount", 5000) // In cents e.g. $10.00
                .set("description", "Hitching a ride");

        Payment payment = Payment.create(paymentsMap);

        if ("APPROVED".equals(payment.get("paymentStatus"))) {
            System.out.println("Payment approved");
            return true;
        }

        return false;
    }

}
