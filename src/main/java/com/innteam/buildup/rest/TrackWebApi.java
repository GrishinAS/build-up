package com.innteam.buildup.rest;

import com.innteam.buildup.commons.model.PaperRequest;
import com.innteam.buildup.commons.model.RoadFolder;
import com.innteam.buildup.commons.model.paper.Paper;
import com.innteam.buildup.commons.model.paper.PaperCrudService;
import com.innteam.buildup.commons.model.user.PaperActivityStatus;
import com.innteam.buildup.commons.model.user.Progress;
import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserCrudService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackWebApi {

  private PaperCrudService paperCrudService;
  private UserCrudService userCrudService;

  @Autowired
  public TrackWebApi(PaperCrudService paperCrudService, UserCrudService userCrudService){
    this.paperCrudService = paperCrudService;
    this.userCrudService = userCrudService;
  }

  @GetMapping("/roadMap")
  public RoadFolder roadMap(@RequestParam String user_name) {
    return new RoadFolder();
  }

  @PostMapping("/progress")
  public ResponseEntity progress(@RequestBody PaperRequest request) {
    return changeProgressStatus(request, PaperActivityStatus.IN_PROGRESS);
  }

  @PostMapping("/skip")
  public ResponseEntity skip(@RequestBody PaperRequest request) {
    return changeProgressStatus(request, PaperActivityStatus.DONE);
  }

  @PostMapping("/finish")
  public ResponseEntity finish(@RequestBody PaperRequest request) {
    return changeProgressStatus(request, PaperActivityStatus.DONE);
  }

  private ResponseEntity changeProgressStatus(@RequestBody PaperRequest request, PaperActivityStatus status) {
    final User anton = userCrudService.read(UUID.fromString(request.getUser_id()));
    final Paper paper = paperCrudService.read(UUID.fromString(request.getPaper_id()));

    anton.getProgressList().add(new Progress(paper, 10L, status));
    userCrudService.update(anton);

    return new ResponseEntity(HttpStatus.OK);
  }
}
