package com.unsplash.demo.service;

import com.unsplash.demo.service.dto.output.CollectionODTO;
import java.util.List;

public interface DemoService {

    List<CollectionODTO> getAllCollections(String filter);

}
