package com.innteam.buildup.commons.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class UserCrudServiceTest {
    @Autowired
    UserCrudService service;

    @Test
    public void test() {
        final User user = new User();
        user.setFreeTime(100);
        user.setName("Anton");
        service.create(user);
    }
}