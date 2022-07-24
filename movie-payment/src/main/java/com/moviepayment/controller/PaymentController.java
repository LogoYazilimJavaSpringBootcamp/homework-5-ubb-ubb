package com.moviepayment.controller;

import com.moviepayment.model.Payment;
import com.moviepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {

        return paymentService.createPayment(payment);
    }



}
