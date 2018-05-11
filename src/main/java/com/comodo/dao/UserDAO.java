package com.comodo.dao;

import com.comodo.model.User;
import java.util.List;

/*
    Created by Dmitriy Laletin 
    on 8:03 PM 5/2/2018 May 2018
*/
public interface UserDAO {

    User save(User user);
    List<User> getAll();
    List<User> getAllByFirstName(String firstName);
    List<User> getAllByLastName(String lastName);
    List<User> getAllByGender(String gender);
    User getById(Long id);
    void remove(Long id);
}
