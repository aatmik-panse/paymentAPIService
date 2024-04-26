package dev.aatmik.paymentservice.paymentgateways;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {
    public String generatePaymentLink(Long orderID, String email) throws RazorpayException, StripeException;

}
