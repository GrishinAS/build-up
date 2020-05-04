package com.innteam.buildup.rest;

import com.innteam.buildup.commons.model.ContentType;
import com.innteam.buildup.commons.model.FinishAllRequest;
import com.innteam.buildup.commons.model.PaperRequest;
import com.innteam.buildup.commons.model.paper.Content;
import com.innteam.buildup.commons.model.progress.Progress;
import com.innteam.buildup.commons.model.progress.ProgressCrudService;
import com.innteam.buildup.commons.model.roadFolders.PointCrudService;
import com.innteam.buildup.commons.model.roadFolders.RoadPoint;
import com.innteam.buildup.commons.model.user.PaperActivityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class TrackWebApi {


    private PointCrudService pointCrudService;
    private ProgressCrudService progressCrudService;

    @Autowired
    public TrackWebApi(PointCrudService pointCrudService,
                       ProgressCrudService progressCrudService) {
        this.pointCrudService = pointCrudService;
        this.progressCrudService = progressCrudService;
    }

    @GetMapping("/roadMap")
    public List<RoadPoint> roadList(@RequestParam String username) {
        return pointCrudService.getMock(); //TODO make return folder by username
    }

    @GetMapping("/content")
    public List<Content> content(@RequestParam ContentType contentType, @RequestParam String pointId) {
        RoadPoint roadPoint = pointCrudService.read(UUID.fromString(pointId)); //TODO make return folder by folderId
        return roadPoint.getContents().stream()
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
        for (String paper : request.getPaperIds()) {
            changeProgressStatus(new PaperRequest(paper, request.getUserId(), request.getTime()), PaperActivityStatus.DONE);
        }
        return ResponseEntity.ok().build();
    }

    private ResponseEntity changeProgressStatus(@RequestBody PaperRequest request, PaperActivityStatus status) {
        final String user_id = request.getUser_id();
        final String contentId = request.getPaper_id();
        final Progress progress = progressCrudService.getProgressFor(UUID.fromString(user_id), UUID.fromString(contentId));
        switch (status) {
            case DONE:
            case SKIPPED:
                progress.setCompletion(1d);
                break;
            case IN_PROGRESS:
                break;
        }
        progress.setStatus(status);

        return ResponseEntity.ok().build();
    }
}
