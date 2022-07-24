package com.movierec.client;
import com.movierec.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "payment-service", url = "${payment.url}")
public interface PaymentClient {

    @PostMapping(value = "/payments")
    Payment createPayment(@RequestBody Payment payment);

}