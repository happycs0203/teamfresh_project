package com.teamfresh.project.api.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Desc Response Return 값
 * @author ChangSu, Ham
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private int count;
    private T list;
}
