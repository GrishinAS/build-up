package com.innteam.buildup.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackWebApi {

  @GetMapping("/greeting")
  public String greeting() {
    return "wow";
  }
}
