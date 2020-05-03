package com.innteam.buildup.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
  private long dailyFreeTime;
  private String user_name;
  private String uuid;
}
