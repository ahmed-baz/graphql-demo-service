package org.demo.app.service.query;


import org.demo.app.exception.AppErrorKeys;
import org.demo.app.exception.AppExceptionResponse;

public abstract class QueryServiceImpl<E> implements QueryService<E> {

    @Override
    public Iterable<E> findAll() {
        return getRepo().findAll();
    }

    @Override
    public Long count() {
        return getRepo().count();
    }

    @Override
    public E findById(Long id) {
        return getRepo().findById(id).orElseThrow(() -> new AppExceptionResponse(AppErrorKeys.NOT_FOUND));
    }
}
