package com.innteam.buildup.commons.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class DomainObjectCrudServiceBase<T extends DomainObject>
        implements DomainCrudService<T> {

    private final PagingAndSortingRepository<T, UUID> repo;

    public DomainObjectCrudServiceBase(PagingAndSortingRepository<T, UUID> repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public UUID create(T object) {
        return this.repo.save(object).getId();
    }

    @Override
    @Transactional
    public T read(UUID id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Collection<T> readAll(int pages, int count) {
        return IterableUtils.toList(this.repo.findAll(PageRequest.of(pages, count, Sort.by(Sort.Direction.DESC, "creationDate"))));
    }

    @Override
    @Transactional
    public Collection<T> readAll() {
        return IterableUtils.toList(this.repo.findAll());
    }

    @Override
    @Transactional
    public T update(T object) {
        return this.repo.save(object);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        this.repo.deleteById(id);
    }
}
