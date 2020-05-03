package com.innteam.buildup.commons.model.roadFolders;

import java.util.List;
import java.util.Set;

import com.innteam.buildup.commons.model.DomainObject;
import com.innteam.buildup.commons.model.paper.Content;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = RoadFolder.TABLE_NAME)
public class RoadFolder extends DomainObject {
  static final String TABLE_NAME = "roadFolders";
  private String name;

  @ManyToMany(
          fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private Set<Content> contents;

  @ManyToMany(
          fetch = FetchType.EAGER,
          cascade = CascadeType.ALL)
  private List<RoadFolder> internal;
}
