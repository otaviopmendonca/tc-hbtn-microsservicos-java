package com.example.demo.controller;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id){
        if(id > 0 && id < 100){
            return "You have entered valid ID";
        }else {
            throw new UserIdException(String.valueOf(id));
        }
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName){
        if(userName.length() > 3 && userName.length() < 15){
            return "You have entered valid USERNAME";
        }else{
            throw new UserNameException(userName);
        }
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf){
        boolean isCPFValid = isCPF(cpf);
        if (isCPF(cpf)) {
            return "You have entered valid CPF";
        }
        throw new CPFException(cpf);
    }

    public boolean isCPF(String CPF) {
        if(CPF.length() > 3 && CPF.length() < 11){
            return true;
        }
        return false;
    }
}