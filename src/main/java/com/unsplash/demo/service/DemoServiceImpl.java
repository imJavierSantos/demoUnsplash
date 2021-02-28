package com.unsplash.demo.service;

import com.unsplash.demo.model.Collection;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import com.unsplash.demo.service.mapper.DemoServiceMapper;
import com.unsplash.demo.service.resource.CollectionResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService{

    private final DemoServiceMapper demoServiceMapper;

    private final CollectionResource collectionResource;

    @Override
    public List<CollectionODTO> getAllCollections(String filter) {
        List<Collection> collections = collectionResource.getCollectionInfo();
        List<CollectionODTO> collectionODTOS = demoServiceMapper.toCollectionODTO(collections);
        return applyFilter(collectionODTOS, filter);
    }


    private List<CollectionODTO> applyFilter(List<CollectionODTO> collectionODTOS, String filter){
        if(Objects.nonNull(filter)){
            return collectionODTOS.stream()
                    .filter(collecion -> Objects.nonNull(collecion.getTitle()) && collecion.getTitle().equalsIgnoreCase(filter) ||
                            Objects.nonNull(collecion.getDescription()) && collecion.getDescription().equalsIgnoreCase(filter) ||
                            Objects.nonNull(collecion.getId()) && collecion.getId().equalsIgnoreCase(filter) ||
                            Objects.nonNull(collecion.getCoverPhotoIds()) && collecion.getCoverPhotoIds().contains(filter))
                    .collect(Collectors.toList());
        } else {
            return collectionODTOS;
        }
    }



}
