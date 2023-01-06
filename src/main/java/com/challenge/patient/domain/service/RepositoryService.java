package com.challenge.patient.domain.service;

public interface RepositoryService<T> extends Service{
    T create(T entity);

    T update(T entity);

    void delete(Long id);
}
