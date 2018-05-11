package com.comodo.controller;

import com.comodo.Result.Result;
import com.comodo.model.User;
import com.comodo.model.UserSearch;
import com.comodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Created by Dmitriy Laletin 
    on 8:13 PM 5/11/2018 May 2018
*/
@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users")
    public List<User> users() {
        return userService.getAll();
    }

    @GetMapping(value = "/user/get", consumes = "application/json", produces = "application/json")
    public User userAdd(@RequestParam("id") String id) {
        return userService.getById(Long.parseLong(id));
    }

    @PostMapping(value = "/user/add", consumes = "application/json", produces = "application/json")
    public Result userAdd(Result result, @RequestBody User user) {
        userService.save(user);
        return result.set(true, "User successfully added!").add("user", user);
    }

    @PostMapping(value = "/user/save", consumes = "application/json", produces = "application/json")
    public Result userSave(Result result, @RequestBody User user) {
        userService.save(user);
        return result.set(true, "User successfully updated!").add("users", userService.getAll());
    }

    @PostMapping(value = "/user/search", consumes = "application/json", produces = "application/json")
    public Result userSave(Result result, @RequestBody UserSearch userSearch) {
        if(!userSearch.getText().isEmpty()) {
            switch (userSearch.getSearchBy()) {
                case "firstName":
                    return result.set(true, "").add("users", userService.getAllByFirstName(userSearch.getText()));
                case "lastName":
                    return result.set(true, "").add("users", userService.getAllByLastName(userSearch.getText()));
                case "gender":
                    return result.set(true, "").add("users", userService.getAllByGender(userSearch.getText()));
                default:
                    return result.set(true, "").add("users", userService.getAll());
            }
        } else {
            return result.set(true, "").add("users", userService.getAll());
        }
    }

    @GetMapping(value = "/user/remove", consumes = "application/json", produces = "application/json")
    public Result userRemove(Result result, @RequestParam("id") String id) {
        userService.remove(Long.parseLong(id));
        return result.set(true, "User "+id+" successfully deleted!");
    }
}
