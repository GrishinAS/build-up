package com.innteam.buildup.commons.model.user;

import com.innteam.buildup.commons.model.DomainObjectCrudServiceBase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Scope("singleton")
public class UserCrudService extends DomainObjectCrudServiceBase<User> {
    @Autowired
    public UserCrudService(UserRepository repo) {
        super(repo);
    }
}
