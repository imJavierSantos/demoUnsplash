package com.unsplash.demo.service.mapper;

import com.unsplash.demo.model.Collection;
import com.unsplash.demo.service.dto.output.CollectionODTO;

import java.util.List;

public interface DemoServiceMapper {

    List<CollectionODTO> toCollectionODTO(List<Collection> collections);

}
