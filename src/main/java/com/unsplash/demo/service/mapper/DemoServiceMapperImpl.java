package com.unsplash.demo.service.mapper;

import com.unsplash.demo.model.Collection;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import com.unsplash.demo.utils.ObjectMapperUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoServiceMapperImpl implements DemoServiceMapper {

    @Override
    public List<CollectionODTO> toCollectionODTO(List<Collection> dataCollections) {
        return ObjectMapperUtils.mapAll(dataCollections, CollectionODTO.class);
    }

}
