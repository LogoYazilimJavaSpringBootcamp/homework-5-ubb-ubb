package com.movierec.controller;


import com.movierec.model.Movie;
import com.movierec.model.Payment;
import com.movierec.model.UserDetails;
import com.movierec.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping(value = "/signup")
    public UserDetails addUser(@RequestBody UserDetails userDetails) {
        return userDetailsService.addUser(userDetails);
    }

    @GetMapping(value = "/all")
    public Iterable<UserDetails> findAll() {
        return userDetailsService.findAll();
    }


    @PostMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        return userDetailsService.loginService(username, password);
    }


    @PutMapping(value = "/{id}/settings")
    public UserDetails changeInfo(@RequestBody UserDetails userDetails, @PathVariable long id) {

        return userDetailsService.change(userDetails,id);
    }

    @PostMapping (value = "/payment")
    public Payment subscribe(@RequestBody Payment payment){

        return userDetailsService.paymentService(payment);
    };

}
