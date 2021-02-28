package com.unsplash.demo.controller;

import com.unsplash.demo.controller.mapper.DemoControllerMapper;
import com.unsplash.demo.controller.rdto.ResponseRSDTO;
import com.unsplash.demo.service.DemoService;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DemoControllerTest {

    @Mock
    private DemoService demoService;

    @Mock
    private DemoControllerMapper demoControllerMapper;

    private DemoController demoController;

    private String filter = "1";
    private List<CollectionODTO> collectionODTOS;
    private List<ResponseRSDTO> responseRSDTOS;

    @BeforeEach
    @SneakyThrows
    public void setUp() {
        this.demoController = new DemoController(demoService, demoControllerMapper);
    }

    @Test
    void shouldSuccessGetAllCollections(){

        this.collectionODTOS = new ArrayList<>();

        when(demoService.getAllCollections(filter)).thenReturn(collectionODTOS);
        when(demoControllerMapper.toResponseRSDTO(collectionODTOS)).thenReturn(responseRSDTOS);

        demoController.getAllCollections(filter);

        verify(demoService).getAllCollections(filter);
        verify(demoControllerMapper).toResponseRSDTO(collectionODTOS);

    }

}
