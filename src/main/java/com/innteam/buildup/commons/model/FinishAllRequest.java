package com.innteam.buildup.commons.model;

import java.util.List;
import lombok.Data;

/**
 * For finish all rest
 */
@Data
public class FinishAllRequest {
  private List<String> paper_ids;
  private String user_id;
  private String time;
}
