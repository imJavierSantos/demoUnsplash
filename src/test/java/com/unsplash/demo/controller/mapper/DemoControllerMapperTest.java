package com.unsplash.demo.controller.mapper;

import com.unsplash.demo.controller.rdto.ResponseRSDTO;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DemoControllerMapperTest {

    private DemoControllerMapper demoControllerMapper;

    private List<CollectionODTO> collectionODTOS;

    @BeforeEach
    @SneakyThrows
    public void setUp() {
        this.demoControllerMapper = new DemoControllerMapperImpl();
    }

    @Test
    void shouldSuccessGetAllCollections(){
        setValuesForTest();
        List<ResponseRSDTO> response = demoControllerMapper.toResponseRSDTO(collectionODTOS);
        checkValuesForTest(response);
    }

    void setValuesForTest(){
        this.collectionODTOS = new ArrayList<>();
        CollectionODTO collectionODTO = new CollectionODTO();
        List<String> coverPhotoIds = new ArrayList<>();
        coverPhotoIds.add("photoId");
        collectionODTO.setCoverPhotoIds(coverPhotoIds);
        collectionODTO.setId("1");
        collectionODTO.setDescription("aaa");
        collectionODTOS.add(collectionODTO);
    }

    void checkValuesForTest(List<ResponseRSDTO> response){
        Assertions.assertEquals("1", response.get(0).getId());
        Assertions.assertEquals("photoId", response.get(0).getCoverPhotoIds().get(0));
        Assertions.assertEquals("aaa", response.get(0).getDescription());
    }

}
