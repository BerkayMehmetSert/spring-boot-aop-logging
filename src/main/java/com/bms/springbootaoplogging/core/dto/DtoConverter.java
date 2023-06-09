package com.bms.springbootaoplogging.core.dto;

import com.bms.springbootaoplogging.core.model.BaseEntity;

import java.util.List;

public interface DtoConverter<D extends Dto, E extends BaseEntity> {
    D convert(E from);

     default List<D> convert(List<E> from) {
        return from.stream().map(this::convert).toList();
    }
}
