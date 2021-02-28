package com.unsplash.demo.controller.mapper;

import com.unsplash.demo.controller.rdto.ResponseRSDTO;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import com.unsplash.demo.utils.ObjectMapperUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoControllerMapperImpl implements DemoControllerMapper{

    @Override
    public List<ResponseRSDTO> toResponseRSDTO(List<CollectionODTO> collectionODTOS) {
        return ObjectMapperUtils.mapAll(collectionODTOS, ResponseRSDTO.class);
    }

}
