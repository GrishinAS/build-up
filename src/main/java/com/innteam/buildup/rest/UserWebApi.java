package com.innteam.buildup.rest;

import com.innteam.buildup.commons.model.User;
import com.innteam.buildup.model.LoginRequest;
import com.innteam.buildup.model.UserData;
import com.innteam.buildup.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWebApi {

  @Autowired
  private AccountsService accountsService;

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody UserData request) {
    User user = new User();
    user.setFreeTime(request.getDailyFreeTime());
    user.setName(request.getUser_name());
    accountsService.save(user);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/login")
  public UserData login(@RequestBody LoginRequest request) {
    User user = accountsService.findByUsername(request.getUserName());
    return UserData.builder()
           .user_name(user.getName())
           .uuid(user.getId().toString())
           .dailyFreeTime(user.getFreeTime())
           .build();
  }
}
