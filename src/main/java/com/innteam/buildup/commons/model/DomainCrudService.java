package com.innteam.buildup.commons.model;

import java.util.Collection;
import java.util.UUID;

public interface DomainCrudService<T extends DomainObject> {

    UUID create(T object);

    T read(UUID id);

    Collection<T> readAll(int pages, int count);

    Collection<T> readAll();

    T update(T object);

    void delete(UUID id);
}