package org.demo.app.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E> {

    void updateEntity(E newOne, @MappingTarget E oldOne);

}
