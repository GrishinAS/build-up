package com.innteam.buildup.commons.model;

import java.util.List;

import com.innteam.buildup.commons.model.paper.Paper;
import lombok.Data;

@Data
public class RoadFolder {
  private String name;
  private List<Paper> papers;
  private List<RoadFolder> internal;
}
