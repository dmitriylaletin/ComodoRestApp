package com.comodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Created by Dmitriy Laletin 
    on 8:13 PM 5/10/2018 May 2018
*/
@Controller
public class RootController {
    @RequestMapping(value = "/")
    public String rootLoad(){
        return "user";
    }
}
