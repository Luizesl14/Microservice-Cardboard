package com.systemorderproducer.aplicatiton.core.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

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


    /**
     * Maps the Page {@code entities} of <code>T</code> type which have to be mapped as input to {@code dtoClass} Page
     * of mapped object with <code>D</code> type.
     *
     * @param <D> - type of objects in result page
     * @param <T> - type of entity in <code>entityPage</code>
     * @param entities - page of entities that needs to be mapped
     * @param dtoClass - class of result page element
     * @return page - mapped page with objects of type <code>D</code>.
     * @NB <code>dtoClass</code> must has NoArgsConstructor!
     */
    public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> modelMapper().map(objectEntity, dtoClass));
    }

}