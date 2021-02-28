package com.unsplash.demo.utils;

import com.unsplash.demo.model.Collection;
import com.unsplash.demo.model.CoverPhoto;
import com.unsplash.demo.model.Source;
import com.unsplash.demo.model.Tags;
import com.unsplash.demo.service.dto.output.CollectionODTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectMapperUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private ObjectMapperUtils() {
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        D object = modelMapper.map(entity, outClass);

        if (object instanceof CollectionODTO && entity instanceof Collection){
            Tags[] tags = ((Collection)entity).getTags();

            List<String> coverPhotoIds = Arrays.stream(tags)
                    .filter(Objects::nonNull).map(Tags::getSource)
                    .filter(Objects::nonNull).map(Source::getCoverPhoto)
                    .filter(Objects::nonNull).map(CoverPhoto::getId).collect(Collectors.toList());

            ((CollectionODTO) object).setCoverPhotoIds(coverPhotoIds);
        }

        return object;
    }

    public static <D, T> List<D> mapAll(final java.util.Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}