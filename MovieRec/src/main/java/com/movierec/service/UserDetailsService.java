package com.movierec.service;

import com.movierec.client.PaymentClient;
import com.movierec.model.Payment;
import com.movierec.model.UserDetails;
import com.movierec.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PaymentClient paymentClient;


    public String loginService(String email, String password) {

        System.out.println(passwordEncoder.encode(password));

        if (userRepository.findAll().stream().anyMatch(i -> passwordEncoder.matches(password, i.getPassword()) && i.getMail().equals(email))) {
            return "Login success.";
        }
        return "Login failed.";



    }

    public Payment paymentService(Payment payment) {

        return paymentClient.createPayment(payment);
    }


    public UserDetails addUser(UserDetails userDetails)  {

        UserDetails user = new UserDetails();


        user.setUsername(userDetails.getUsername());
        user.setMail(userDetails.getMail());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));


        return userRepository.save(user);


    }

    public Iterable<UserDetails> findAll() {
        return userRepository.findAll();
    }


    public UserDetails change(UserDetails userDetails, long id) {

        UserDetails user = userRepository.findAll().stream().filter(i -> passwordEncoder.matches(userDetails.getPassword(), i.getPassword()) && i.getId() == id).findAny().get();

        user.setPassword(userDetails.getPassword());
        user.setUsername(userDetails.getUsername());

        return userRepository.save(user);
    }
}
