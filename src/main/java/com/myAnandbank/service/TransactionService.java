package com.myAnandbank.service;

import com.myAnandbank.model.Transactions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
