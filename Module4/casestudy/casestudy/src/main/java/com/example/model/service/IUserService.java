package com.example.model.service;

import com.example.model.entity.AppUser;


import java.util.Optional;

public interface IUserService extends IService<AppUser> {
     Optional<AppUser> findByUsername(String username);
     void remove(String username);

}
