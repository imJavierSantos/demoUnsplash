package com.unsplash.demo.model;

import lombok.Data;

@Data
public class Collection {

    private String id;

    private String title;

    private String description;

    private Tags[] tags;

}
