package com.mkyong.dao;

import com.mkyong.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {

        List<Customer> result = jdbcTemplate.query(
                "SELECT customer_id, first_name, email_id, city FROM customer",
                (rs, rowNum) -> new Customer(rs.getInt("customer_id"),
                        rs.getString("first_name"), rs.getString("email_id"), rs.getString("city"))
        );

        return result;

    }

}
