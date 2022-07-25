package com.moviepayment.service;

import com.moviepayment.model.Payment;
import com.moviepayment.repository.PaymentRepository;
import com.moviepayment.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    public Payment createPayment(Payment payment) {

        log.info("Payment test");

        userRepository.save(payment);
        return paymentRepository.save(payment);

    }
}
