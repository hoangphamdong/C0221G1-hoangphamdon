package com.example.model.service;


import com.example.model.bean.Login;
import com.example.model.bean.User;

public interface IUserService {
 User checkLogin(Login login);
}
