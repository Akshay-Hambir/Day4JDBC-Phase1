package com.project;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public User user1(){
        User us = new User();
        us.setUsername("NewUser1");
        us.setPassword("newPass");
        return us;
    }

    @Bean
    public User user(){
        User us = new User();
        us.setUsername("NewUser");
        us.setPassword("newPass");
        return us;
    }

    @Bean
    public DataConnect dao(){
        DBConnect obj = new DBConnect();
        obj.setDataSource(getDs());
        return obj;
    }


    @Bean
    public DataSource getDs(){
        DriverManagerDataSource ref = new DriverManagerDataSource();
        ref.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ref.setUrl("jdbc:mysql://localhost:3306/test");
        ref.setUsername("root");
        ref.setPassword("Admin@123");
        return ref;
    }
}
