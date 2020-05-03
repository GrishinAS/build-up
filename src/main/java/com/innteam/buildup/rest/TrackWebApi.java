package com.innteam.buildup.rest;

import com.innteam.buildup.model.PaperRequest;
import com.innteam.buildup.model.RoadFolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackWebApi {

  @GetMapping("/roadMap")
  public RoadFolder roadMap(@RequestParam String user_name) {
    return new RoadFolder();
  }

  @PostMapping("/finish")
  public ResponseEntity finish(@RequestBody PaperRequest request) {
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/skip")
  public ResponseEntity skip(@RequestBody PaperRequest request) {
    return new ResponseEntity(HttpStatus.OK);
  }
}
