package com.innteam.buildup.service;

import com.innteam.buildup.commons.model.User;

public interface AccountsService {
  User save(User account);
  User findByUsername(String username);
}
