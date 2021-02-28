package com.unsplash.demo.controller.mapper;

import com.unsplash.demo.controller.rdto.ResponseRSDTO;
import com.unsplash.demo.service.dto.output.CollectionODTO;

import java.util.List;

public interface DemoControllerMapper {

    List<ResponseRSDTO> toResponseRSDTO(List<CollectionODTO> collectionODTOS);

}
