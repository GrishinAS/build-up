package com.innteam.buildup.commons.model;

import java.util.Optional;
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

  public User findByUsername(String username) {
    Optional<User> user = readAll().stream()
                          .filter(u -> u.getName().equals(username))
                          .findFirst();

    if (!user.isPresent()) {
      throw new RuntimeException("User does not exist");
    }
    return user.get();
  }
}
