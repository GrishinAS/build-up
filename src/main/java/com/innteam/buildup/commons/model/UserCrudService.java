package com.innteam.buildup.commons.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Scope("singleton")
public class UserCrudService extends DomainObjectCrudServiceBase<User> {
    @Autowired
    public UserCrudService(UserRepository repo) {
        super(repo);
    }
}
