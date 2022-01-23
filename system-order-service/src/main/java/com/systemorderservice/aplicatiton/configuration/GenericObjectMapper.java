package com.systemorderservice.aplicatiton.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class GenericObjectMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Maps the source to destination class.
     *
     * @param source    Source.
     * @param destClass Destination class.
     * @return Instance of destination class.
     */
    public <S, D> D mapTo(S source, Class<D> destClass) {
        return modelMapper().map(source, destClass);
    }

    /**
     * Maps the list source to destination class.
     *
     * @param list      List source.
     * @param destClass Destination class.
     * @return Instance of destination class.
     */

    public <S, D> List<D> mapListTo(List<S> list, Class<D> destClass) {
        return list.stream()
                .map(s -> modelMapper().map(s, destClass))
                .collect(Collectors.toList());
    }
}