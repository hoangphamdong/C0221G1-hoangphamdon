package com.example.model.service.impl;

import com.example.model.bean.Login;
import com.example.model.bean.User;
import com.example.model.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private static List<User>users;
    static {
        users=new ArrayList<>();
        User u1=new User("john","123456","John","john@codegym.vn",10);
        User u2=new User("bill","123456","Bill","bill@codegym.vn",15);
        User u3=new User("mike","123456","Mike","mike@codegym.vn",16);

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    @Override
    public User checkLogin(Login login) {
        for(User u:users){
            if(u.getAccount().equals(login.getAccount())
            && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
