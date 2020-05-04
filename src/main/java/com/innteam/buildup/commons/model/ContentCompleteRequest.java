package com.innteam.buildup.commons.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * For finish and skip content
 */
@Data
@AllArgsConstructor
public class ContentCompleteRequest {
  private String contentId;
  private String userId;
  private String time;
}
