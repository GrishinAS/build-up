package com.innteam.buildup.commons.model.progress;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserCrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgressCrudService extends DomainObjectCrudServiceBase<Progress> {
    @Autowired
    UserCrudService userCrudService;

    public ProgressCrudService(PagingAndSortingRepository<Progress, UUID> repo) {
        super(repo);
    }

    public Progress getProgressFor(UUID userId, UUID contentId) {
        final User user = userCrudService.read(userId);
        //обязан быть один иначе плохо
        return user.getProgressList().stream().filter(
                p -> p.getContent().getId().equals(contentId)).collect(Collectors.toList()).get(0);
    }

}
