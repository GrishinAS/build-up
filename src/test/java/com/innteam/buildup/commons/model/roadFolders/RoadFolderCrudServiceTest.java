package com.innteam.buildup.commons.model.roadFolders;

import com.innteam.buildup.commons.model.paper.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class RoadFolderCrudServiceTest {
    @Autowired
    RoadFolderCrudService service;

    @Test
    public void test() {
        final RoadFolder roadFolder1 = new RoadFolder("SE", List.of(new Paper("sePaper", "https://github.com/se-edu/se-book", 100000)), List.of());
        final RoadFolder roadFolder2 = new RoadFolder("DB", List.of(new Paper("dbPaper", "https://bookauthority.org/books/best-databases-books", 100000)), List.of());
        final RoadFolder roadFolder = new RoadFolder("Java", List.of(
                new Paper("javaPaper",
                        "https://github.com/muhdkhokhar/test/blob/master/Joshua%20Bloch%20-%20Effective%20Java%20(3rd)%20-%202018.pdf",
                        100000)),
                java.util.List.of(roadFolder1, roadFolder2));
        service.create(roadFolder);
    }
}