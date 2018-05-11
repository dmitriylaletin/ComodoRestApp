package com.comodo.Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/*
    Created by Dmitriy Laletin 
    on 8:12 PM 5/11/2018 May 2018
*/
public class Result {
    private boolean status = false;
    private String message = "";

    @JsonProperty("data")
    private Map<String, Object> data = new HashMap<>();

    public Result() { }

    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public void init() { }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Result set(boolean status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    public Result add(String key, Object object) {
        data.put(key, object);
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
