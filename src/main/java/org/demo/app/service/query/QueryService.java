package org.demo.app.service.query;


import graphql.kickstart.tools.GraphQLQueryResolver;
import org.demo.app.repo.BaseRepo;

public interface QueryService<E> extends GraphQLQueryResolver {

    Iterable<E> findAll();

    Long count();

    E findById(Long id);

    BaseRepo<E> getRepo();

}
