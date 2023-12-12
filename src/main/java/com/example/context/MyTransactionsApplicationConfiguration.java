package com.example.context;

import com.example.ApplicationLauncher;
import com.example.model.Transactions;
import com.example.model.User;
import com.example.service.TransactionService;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@EnableWebMvc
@EnableTransactionManagement
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

    @Bean
    public DataSource dataSource(){
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:~/myFirstH2Database;INIT=RUNSCRIPT FROM 'classpath:schema.sql'");
        ds.setUser("sa");
        ds.setPassword("sa");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public TransactionManager platformTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }


}
