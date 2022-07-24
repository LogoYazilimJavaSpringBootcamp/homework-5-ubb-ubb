package com.moviepayment.repository;

import com.moviepayment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Payment payment) {

        jdbcTemplate.update("UPDATE user_details SET status = 1, WHERE id = ?", payment.getUser_id());
        return;
    }

}
