package com.innteam.buildup.commons.model.progress;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import com.innteam.buildup.commons.model.paper.Content;
import com.innteam.buildup.commons.model.paper.ContentCrudService;
import com.innteam.buildup.commons.model.user.PaperActivityStatus;
import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserCrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgressCrudService extends DomainObjectCrudServiceBase<Progress> {
    final
    UserCrudService userCrudService;
    final
    ContentCrudService contentCrudService;

    public ProgressCrudService(PagingAndSortingRepository<Progress, UUID> repo, UserCrudService userCrudService, ContentCrudService contentCrudService) {
        super(repo);
        this.userCrudService = userCrudService;
        this.contentCrudService = contentCrudService;
    }

    public Progress getProgressFor(UUID userId, UUID contentId) {
        final User user = userCrudService.read(userId);
        final List<Progress> progressList = user.getProgressList();
        //обязан быть один иначе плохо. Нас интересует прогресс по конкретному контенту.
        final List<Progress> contentProgress = progressList.stream().filter(
                p -> p.getContent().getId().equals(contentId)).collect(Collectors.toList());
        //если прогресса по этой статье нет, то создаем его
        if (contentProgress.isEmpty()) {
            //для конкретного контента
            final Content content = contentCrudService.read(contentId);
            final Progress progress = new Progress(content, 0L, 0d, PaperActivityStatus.IN_PROGRESS);
            //кладем в бд
            final UUID created = create(progress);
            final Progress createdProgress = read(created);
            //и юзера обновляем
            progressList.add(createdProgress);
            userCrudService.update(user);
            return createdProgress;
        }
        return contentProgress.get(0);
    }

}
