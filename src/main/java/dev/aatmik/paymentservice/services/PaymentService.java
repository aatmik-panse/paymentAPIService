package dev.aatmik.paymentservice.services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.aatmik.paymentservice.paymentgateways.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;
    PaymentService (PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderID , String email) throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(orderID, email);
    }
}
