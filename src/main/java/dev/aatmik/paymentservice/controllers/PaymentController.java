package dev.aatmik.paymentservice.controllers;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.aatmik.paymentservice.dtos.InitiatePaymentRequestDto;
import dev.aatmik.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws RazorpayException, StripeException {
        return paymentService.initiatePayment(
                initiatePaymentRequestDto.getOrderID(),
                initiatePaymentRequestDto.getEmail()
        );
    }
}
