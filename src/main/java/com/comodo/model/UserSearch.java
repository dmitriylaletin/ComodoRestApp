package com.comodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Created by Dmitriy Laletin 
    on 8:02 PM 5/10/2018 May 2018
*/
public class UserSearch {
    @JsonProperty("searchBy")
    private String searchBy;

    @JsonProperty("text")
    private String text;

    public String getSearchBy() {
        return searchBy;
    }

    public String getText() {
        return text;
    }
}
