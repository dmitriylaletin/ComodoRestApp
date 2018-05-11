package com.comodo.service;

import com.comodo.dao.UserDAO;
import com.comodo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Created by Dmitriy Laletin 
    on 8:31 PM 5/3/2018 May 2018
*/
@Service
public class userServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void remove(long id) {
        userDAO.remove(id);
    }

    @Override
    public List<User> getAllByFirstName(String firstName) {
        return userDAO.getAllByFirstName(firstName);
    }

    @Override
    public List<User> getAllByLastName(String lastName) {
        return userDAO.getAllByLastName(lastName);
    }

    @Override
    public List<User> getAllByGender(String gender) {
        return userDAO.getAllByGender(gender);
    }
}
