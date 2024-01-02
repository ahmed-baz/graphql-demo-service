package org.demo.app.service.mutation;


import org.demo.app.exception.AppErrorKeys;
import org.demo.app.exception.AppExceptionResponse;

import java.util.Optional;


public abstract class MutationServiceImpl<E> implements MutationService<E> {

    @Override
    public E create(E e) {
        return getRepo().save(e);
    }

    @Override
    public E update(Long id, E e) {
        Optional<E> optionalEntity = getRepo().findById(id);
        if (optionalEntity.isPresent()) {
            getMapper().updateEntity(e, optionalEntity.get());
            return getRepo().save(optionalEntity.get());
        }
        throw new AppExceptionResponse(AppErrorKeys.NOT_FOUND);
    }

    @Override
    public boolean delete(Long id) {
        Optional<E> entity = getRepo().findById(id);
        if (entity.isPresent()) {
            getRepo().deleteById(id);
            return true;
        }
        throw new AppExceptionResponse(AppErrorKeys.NOT_FOUND);
    }

}
