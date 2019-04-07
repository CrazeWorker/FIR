package com.demo;


import com.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloDemo {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello world!");
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account){
        System.out.println("保存客户信息");
        System.out.println(account);
        return "success";
    }
}
