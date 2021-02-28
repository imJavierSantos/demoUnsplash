package com.unsplash.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Source {

    @JsonProperty(value = "cover_photo")
    private CoverPhoto coverPhoto;

}
