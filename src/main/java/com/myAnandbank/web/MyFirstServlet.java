package com.myAnandbank.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myAnandbank.context.Application;
import com.myAnandbank.model.Transactions;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getRequestURI().equalsIgnoreCase("/transactions")){
            response.setContentType("application/json; charset=UTF-8");
            List<Transactions> transactions = Application.transactionService.findAll();
            response.getWriter().print(Application.objectMapper.writeValueAsString(transactions));
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getRequestURI().equalsIgnoreCase("/transactions")){
                Integer amount = Integer.valueOf(request.getParameter("amount"));
                String userId = request.getParameter("userId");
                Transactions transactions = Application.transactionService.create(amount, userId);
                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().print(Application.objectMapper.writeValueAsString(transactions));
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}
