package com.example.service;

import com.example.model.Transactions;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    UserService userService;

    public TransactionService(UserService userService){
        this.userService = userService;
    }


    List<Transactions> transactions = new CopyOnWriteArrayList<>();

    public List<Transactions> findAll(){
        return transactions;
    }

    public Transactions create(Integer amount, String userId){
        if(userService.findById(userId) == null){
            throw new IllegalStateException();
        }
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        Transactions transactions1 = new Transactions(amount, timeStamp);
        transactions.add(transactions1);
        return transactions1;
    }
}
