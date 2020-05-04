package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PointCrudService extends DomainObjectCrudServiceBase<RoadPoint> {
    @Autowired
    RoadFolderCrudService folderCrudService;

    public PointCrudService(PagingAndSortingRepository<RoadPoint, UUID> repo) {
        super(repo);
    }

    public List<RoadPoint> getMock() {
        List<RoadPoint> result = new ArrayList<>();


        final RoadFolder folder = folderCrudService.read(folderCrudService.create(new RoadFolder("Java", result)));
        return folder.getInternal();
    }
}
