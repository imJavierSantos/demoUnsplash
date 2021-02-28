package com.unsplash.demo.service.resource;

import com.unsplash.demo.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CollectionResource {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<Collection> getCollectionInfo() {
        ResponseEntity<Collection[]> responseEntity = restTemplate.getForEntity(getUrl(), Collection[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    private String getUrl(){
        return url.concat( "?client_id=").concat(apiKey);
    }

}
