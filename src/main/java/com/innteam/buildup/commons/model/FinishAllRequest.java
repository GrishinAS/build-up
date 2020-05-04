package com.innteam.buildup.commons.model;

import lombok.Data;

import java.util.List;

/**
 * For finish all rest
 */
@Data
public class FinishAllRequest {
    private List<String> paperIds;
    private String userId;
    private String time;
}
