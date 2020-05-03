package com.innteam.buildup.rest;

import com.innteam.buildup.commons.model.LoginRequest;
import com.innteam.buildup.commons.model.UserData;
import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWebApi {

  @Autowired
  private UserCrudService userCrudService;

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody UserData request) {
    User user = new User(request.getUser_name(), request.getDailyFreeTime(), request.getWeeklyFreeTime());
    userCrudService.create(user);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/login")
  public UserData login(@RequestBody LoginRequest request) {
    User user = userCrudService.findByUsername(request.getUserName());
    return UserData.builder()
           .user_name(user.getName())
           .uuid(user.getId().toString())
           .dailyFreeTime(user.getFreeTimePerDay())
           .weeklyFreeTime(user.getFreeDaysPerWeek())
           .build();
  }
}
