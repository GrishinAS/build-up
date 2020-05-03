package com.innteam.buildup.commons.model.paper;

import com.innteam.buildup.commons.model.DomainObject;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Paper.TABLE_NAME)
public class Paper extends DomainObject {
  static final String TABLE_NAME = "papers";
  private String name;
  private String link;
  private int timeInSeconds;
}
