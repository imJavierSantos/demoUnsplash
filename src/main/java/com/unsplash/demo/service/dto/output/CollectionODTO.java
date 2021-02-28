package com.unsplash.demo.service.dto.output;

import lombok.Data;

import java.util.List;

@Data
public class CollectionODTO {

    private String id;

    private String title;

    private String description;

    private List<String> coverPhotoIds;

}
