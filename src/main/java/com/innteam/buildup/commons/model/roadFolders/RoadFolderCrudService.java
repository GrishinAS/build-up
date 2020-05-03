package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import com.innteam.buildup.commons.model.paper.Paper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Scope("singleton")
public class RoadFolderCrudService extends DomainObjectCrudServiceBase<RoadFolder> {

    public RoadFolderCrudService(PagingAndSortingRepository<RoadFolder, UUID> repo) {
        super(repo);
    }

    RoadFolder getMock() {
        final RoadFolder roadFolder1 = new RoadFolder("SE", List.of(new Paper("sePaper", "https://github.com/se-edu/se-book", 100000)), List.of());
        final RoadFolder roadFolder2 = new RoadFolder("DB", List.of(new Paper("dbPaper", "https://bookauthority.org/books/best-databases-books", 100000)), List.of());
        return new RoadFolder("Java", List.of(
                new Paper("javaPaper",
                        "https://github.com/muhdkhokhar/test/blob/master/Joshua%20Bloch%20-%20Effective%20Java%20(3rd)%20-%202018.pdf",
                        100000)),
                java.util.List.of(roadFolder1, roadFolder2));
    }
}
