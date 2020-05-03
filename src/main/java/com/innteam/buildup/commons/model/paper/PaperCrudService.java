package com.innteam.buildup.commons.model.paper;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import com.innteam.buildup.commons.model.user.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Scope("singleton")
public class PaperCrudService extends DomainObjectCrudServiceBase<Paper> {
    public PaperCrudService(PagingAndSortingRepository<Paper, UUID> repo) {
        super(repo);
    }
}
