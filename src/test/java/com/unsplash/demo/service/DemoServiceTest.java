package com.unsplash.demo.service;

import com.unsplash.demo.model.Collection;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import com.unsplash.demo.service.mapper.DemoServiceMapper;
import com.unsplash.demo.service.resource.CollectionResource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
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
class DemoServiceTest {


    @Mock
    private DemoServiceMapper demoServiceMapper;

    @Mock
    private CollectionResource collectionResource;

    private DemoService demoService;

    private String filter = "1";
    private List<CollectionODTO> collectionODTOS;
    private List<Collection> collections;

    @BeforeEach
    @SneakyThrows
    public void setUp() {
        this.demoService = new DemoServiceImpl(demoServiceMapper, collectionResource);
    }

    @Test
    void shouldSuccessGetAllCollections(){

        setValuesForTest();

        when(collectionResource.getCollectionInfo()).thenReturn(collections);
        when(demoServiceMapper.toCollectionODTO(collections)).thenReturn(collectionODTOS);

        List<CollectionODTO> response = demoService.getAllCollections(null);

        verify(collectionResource).getCollectionInfo();
        verify(demoServiceMapper).toCollectionODTO(collections);

        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals("hola", response.get(0).getTitle());
        Assertions.assertEquals("adios", response.get(1).getTitle());

    }

    @Test
    void shouldSuccessGetAllCollectionsFilter(){
        setValuesForTest();

        when(collectionResource.getCollectionInfo()).thenReturn(collections);
        when(demoServiceMapper.toCollectionODTO(collections)).thenReturn(collectionODTOS);

        List<CollectionODTO> response = demoService.getAllCollections("adios");

        verify(collectionResource).getCollectionInfo();
        verify(demoServiceMapper).toCollectionODTO(collections);

        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals("adios", response.get(0).getTitle());
    }


    void setValuesForTest(){
        this.collectionODTOS = new ArrayList<>();
        CollectionODTO collectionODTO = new CollectionODTO();
        collectionODTO.setId("1");
        collectionODTO.setDescription("hola");
        collectionODTO.setTitle("hola");
        List<String> coverPhotoIds = new ArrayList<>();
        coverPhotoIds.add("1");
        collectionODTO.setCoverPhotoIds(coverPhotoIds);

        CollectionODTO collectionODTO2 = new CollectionODTO();
        collectionODTO2.setId("2");
        collectionODTO2.setDescription("adios");
        collectionODTO2.setTitle("adios");
        coverPhotoIds.add("2");
        collectionODTO2.setCoverPhotoIds(coverPhotoIds);

        collectionODTOS.add(collectionODTO);
        collectionODTOS.add(collectionODTO2);
    }

}
