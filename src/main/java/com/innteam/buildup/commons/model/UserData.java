package com.innteam.buildup.commons.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
  private long dailyFreeTime;
  private int weeklyFreeTime;
  private String user_name;
  private String uuid;
}
