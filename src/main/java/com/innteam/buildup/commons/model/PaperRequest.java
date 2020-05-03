package com.innteam.buildup.commons.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * For finish and skip rests
 */
@Data
@AllArgsConstructor
public class PaperRequest {
  private String paper_id;
  private String user_id;
  private String time;
}
