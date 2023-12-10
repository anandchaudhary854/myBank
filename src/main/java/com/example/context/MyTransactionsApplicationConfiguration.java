package com.example.context;

import com.example.ApplicationLauncher;
import com.example.model.User;
import com.example.service.TransactionService;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
public class MyTransactionsApplicationConfiguration {
//    @Bean
//    public UserService userService(){
//        return new UserService();
//    }
//
//    @Bean
//    public TransactionService transactionService(UserService userService){
//        return new TransactionService(userService);
//    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
