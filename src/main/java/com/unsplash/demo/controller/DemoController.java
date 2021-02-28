package com.unsplash.demo.controller;

import com.unsplash.demo.controller.mapper.DemoControllerMapper;
import com.unsplash.demo.controller.rdto.ResponseRSDTO;
import com.unsplash.demo.service.DemoService;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    private final DemoControllerMapper demoControllerMapper;

    @ResponseBody
    @RequestMapping(value = "/collection/all", method = RequestMethod.GET, produces = "application/json")
    public List<ResponseRSDTO> getAllCollections(String filter){

        List<CollectionODTO> collectionODTOS = demoService.getAllCollections(filter);

        return demoControllerMapper.toResponseRSDTO(collectionODTOS);

    }



}
