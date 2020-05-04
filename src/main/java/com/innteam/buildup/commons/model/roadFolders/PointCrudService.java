package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PointCrudService extends DomainObjectCrudServiceBase<RoadPoint> {

    public PointCrudService(PagingAndSortingRepository<RoadPoint, UUID> repo) {
        super(repo);
    }

    public List<RoadPoint> getMock() {
        List<RoadPoint> result = new ArrayList<>();
        return result;
    }
}
