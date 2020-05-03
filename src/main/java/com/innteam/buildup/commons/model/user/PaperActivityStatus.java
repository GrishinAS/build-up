package com.innteam.buildup.commons.model.user;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum PaperActivityStatus {
    DONE, SKIPPED, IN_PROGRESS
}
