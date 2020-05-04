package com.innteam.buildup.commons.model.paper;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Scope("singleton")
public class ContentCrudService extends DomainObjectCrudServiceBase<Content> {
    public ContentCrudService(PagingAndSortingRepository<Content, UUID> repo) {
        super(repo);
    }
}
