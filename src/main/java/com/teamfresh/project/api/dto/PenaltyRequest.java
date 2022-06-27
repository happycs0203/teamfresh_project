package com.teamfresh.project.api.dto;

import com.teamfresh.project.domain.YesNo;
import lombok.Data;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 패널티 리퀘스트
 */
@Data
public class PenaltyRequest {
    private int vocId;

    private YesNo confirmYn;

    private YesNo appealYn;
}
