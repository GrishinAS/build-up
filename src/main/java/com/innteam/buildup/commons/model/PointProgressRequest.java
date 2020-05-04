package com.innteam.buildup.commons.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class PointProgressRequest {
    String userId;
    String pointId;
}
