package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.ContentType;
import com.innteam.buildup.commons.model.paper.Content;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class RoadFolderCrudServiceTest {
    @Autowired
    RoadFolderCrudService service;

    @Test
    public void test() {
        final Content content1 = new Content(ContentType.BOOK, "sePaper", "test", "https://github.com/se-edu/se-book", 100000);
        final RoadPoint roadPoint1 = new RoadPoint("SE", "test", Set.of(content1));
        final Content content2 = new Content(ContentType.BOOK, "dbPaper", "test", "https://bookauthority.org/books/best-databases-books", 100000);
        final RoadPoint roadPoint2 = new RoadPoint("DB", "test", Set.of(content2));
        List<RoadPoint> roadPoints = new ArrayList<>();
        roadPoints.add(roadPoint1);
        roadPoints.add(roadPoint2);
        final RoadFolder roadFolder = new RoadFolder("Java",
                roadPoints);
        final UUID uuid = service.create(roadFolder);

        final RoadFolder folder = service.read(uuid);
        Assert.assertEquals(2, folder.getInternal().size());
    }
}