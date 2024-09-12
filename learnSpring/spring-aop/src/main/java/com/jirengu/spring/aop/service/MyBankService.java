package com.jirengu.spring.aop.service;

import com.jirengu.spring.aop.annotation.An2;
import com.jirengu.spring.aop.annotation.MyAnnotation;
import com.jirengu.spring.aop.annotation.MyLogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class MyBankService {

    @MyLogAnnotation
    public int inquiryBalance() {
        System.out.println("inquiryBalance 被执行");
        return 1000;
    }

    @An2
    @MyAnnotation
    public void saveMoney(int id, int money) {
        System.out.println("saveMoney 被执行");
    }

    public void withdrawMoney(int id, int money) {
        System.out.println("withdrawMoney 被执行");
    }
}
