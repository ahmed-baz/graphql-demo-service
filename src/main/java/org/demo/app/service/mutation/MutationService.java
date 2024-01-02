package org.demo.app.service.mutation;


import graphql.kickstart.tools.GraphQLMutationResolver;
import org.demo.app.mapper.BaseMapper;
import org.demo.app.repo.BaseRepo;


public interface MutationService<E> extends GraphQLMutationResolver {

    E create(E e);

    E update(Long id, E e);

    boolean delete(Long id);

    BaseRepo<E> getRepo();

    BaseMapper<E> getMapper();

}
