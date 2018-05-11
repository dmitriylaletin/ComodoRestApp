package com.comodo.service;

import com.comodo.model.User;
import java.util.List;

/*
    Created by Dmitriy Laletin 
    on 8:32 PM 5/3/2018 May 2018
*/
public interface UserService {
    User save(User user);
    List<User> getAll();
    User getById(long id);
    void remove(long id);
    List<User> getAllByFirstName(String firstName);
    List<User> getAllByLastName(String lastName);
    List<User> getAllByGender(String gender);
}
