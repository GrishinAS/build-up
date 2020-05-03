package com.innteam.buildup.service;

import com.innteam.buildup.commons.model.user.User;

public interface AccountsService {
  User save(User account);
  User findByUsername(String username);
}
