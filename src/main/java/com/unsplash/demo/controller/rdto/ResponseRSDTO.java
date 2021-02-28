package com.unsplash.demo.controller.rdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseRSDTO {

    private String id;

    private String title;

    private String description;

    @JsonProperty(value = "cover_photo_ids")
    private List<String> coverPhotoIds;

}
