package com.innteam.buildup.service.impl;

import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserRepository;
import com.innteam.buildup.service.AccountsService;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountsServiceImpl implements AccountsService {
  @PersistenceContext
  private EntityManager em;

  @Autowired
  private UserRepository repository;

  @Override
  @Transactional
  public User save(User account) {
    return repository.save(account);
  }

  @Override
  public User findByUsername(String username) {
    List<User> allUser = repository.findAll();
    Optional<User> user = allUser.stream()
                          .filter(u -> u.getName().equals(username))
                          .findFirst();

    if(!user.isPresent()){
      throw new RuntimeException("User does not exist");
    }
    return user.get();
  }
}
