package com.innteam.buildup.rest;

import com.innteam.buildup.model.LoginRequest;
import com.innteam.buildup.model.UserData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWebApi {

  @PostMapping("/register")
  public String register(@RequestBody UserData request) {
    return "ok";
  }

  @PostMapping("/login")
  public UserData login(@RequestBody LoginRequest request) {
    return new UserData();
  }
}
