package com.innteam.buildup.commons.model;

import com.innteam.buildup.commons.model.paper.Paper;
import com.innteam.buildup.commons.model.user.PaperActivityStatus;
import com.innteam.buildup.commons.model.user.Progress;
import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserCrudService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class UserCrudServiceTest {
    @Autowired
    UserCrudService service;

    @Test
    public void test() {
        final User user = new User();
        user.setFreeTimePerDay(100);
        user.setName("Anton");
        final UUID uuid = service.create(user);

        final User anton = service.read(uuid);
        final Paper paper = new Paper("Endpoints", "https://docs.google.com/document/d/1NS2ziIaUn4BlfwuSzG0CzbgxfN-wbIPW6dX5VjEUBOg/edit", 1000);
        anton.getProgressList().add(new Progress(paper, 10L, PaperActivityStatus.IN_PROGRESS));

        service.update(anton);
    }
}