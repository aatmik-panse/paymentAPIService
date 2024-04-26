package dev.aatmik.paymentservice.paymentgateways;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.Stripe;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderID, String email) throws StripeException {
        Stripe.apiKey = "sk_test_51P9KixSFSaYlpN7YcGe6gBuhmNaxGmOG2DY5jmgPeCAtzxY2W8Qkk5sQtysxhVGnIOJdo7fF9xF59AC8jpAmQjk400sitaDajX";

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1P9lMCSFSaYlpN7YkllK5gEH")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.toString();
    }

}
