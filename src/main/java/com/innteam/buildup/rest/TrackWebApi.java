package com.innteam.buildup.rest;

import com.innteam.buildup.commons.model.ContentType;
import com.innteam.buildup.commons.model.FinishAllRequest;
import com.innteam.buildup.commons.model.PaperRequest;
import com.innteam.buildup.commons.model.paper.Content;
import com.innteam.buildup.commons.model.paper.PaperCrudService;
import com.innteam.buildup.commons.model.roadFolders.RoadFolderCrudService;
import com.innteam.buildup.commons.model.user.PaperActivityStatus;
import com.innteam.buildup.commons.model.user.Progress;
import com.innteam.buildup.commons.model.user.User;
import com.innteam.buildup.commons.model.user.UserCrudService;
import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.innteam.buildup.commons.model.roadFolders.RoadFolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackWebApi {

  private PaperCrudService paperCrudService;
  private UserCrudService userCrudService;
  private RoadFolderCrudService roadCrudService;

  @Autowired
  public TrackWebApi(PaperCrudService paperCrudService, UserCrudService userCrudService, RoadFolderCrudService roadCrudService){
    this.paperCrudService = paperCrudService;
    this.userCrudService = userCrudService;
    this.roadCrudService = roadCrudService;
  }

  @GetMapping("/roadMap")
  public RoadFolder roadMap(@RequestParam String username) {
    return roadCrudService.getMock(); //TODO make return folder by username
  }

  @GetMapping("/content")
  public List<Content> roadMap(@RequestParam ContentType contentType, @RequestParam String folderId) {
    RoadFolder roadFolder = roadCrudService.getMock(); //TODO make return folder by folderId
    return roadFolder.getContents().stream()
                            .filter(content -> content.getContentType().equals(contentType))
                            .collect(Collectors.toList());
  }

  @PostMapping("/progress")
  public ResponseEntity progress(@RequestBody PaperRequest request) {
    return changeProgressStatus(request, PaperActivityStatus.IN_PROGRESS);
  }

  @PatchMapping("/skip")
  public ResponseEntity skip(@RequestBody PaperRequest request) {
    return changeProgressStatus(request, PaperActivityStatus.DONE);
  }

  @PatchMapping("/finish")
  public ResponseEntity finish(@RequestBody PaperRequest request) {
    return changeProgressStatus(request, PaperActivityStatus.DONE);
  }

  @PatchMapping("/finishFolder")
  public ResponseEntity finishFolder(@RequestBody FinishAllRequest request) {
    for(String paper: request.getPaper_ids()){
      changeProgressStatus(new PaperRequest(paper, request.getUser_id(), request.getTime()), PaperActivityStatus.DONE);
    }
    return ResponseEntity.ok().build();
  }

  private ResponseEntity changeProgressStatus(@RequestBody PaperRequest request, PaperActivityStatus status) {
    final User anton = userCrudService.read(UUID.fromString(request.getUser_id()));
    final Content content = paperCrudService.read(UUID.fromString(request.getPaper_id()));

    anton.getProgressList().add(new Progress(content, Long.parseLong(request.getTime()), status)); //??
    userCrudService.update(anton);

    return ResponseEntity.ok().build();
  }
}
