package com.myAnandbank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myAnandbank.service.TransactionService;
import com.myAnandbank.service.UserService;

public class Application {
    public static final UserService userService = new UserService();
    public static final TransactionService transactionService = new TransactionService(userService);

    public static final ObjectMapper objectMapper = new ObjectMapper();
}
