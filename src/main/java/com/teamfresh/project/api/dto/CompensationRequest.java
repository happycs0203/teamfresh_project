package com.teamfresh.project.api.dto;

import com.teamfresh.project.domain.YesNo;
import lombok.Data;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 리퀘스트
 */
@Data
public class CompensationRequest {

    private int vocId;

    private int compensationAmount; //배상금액

    private YesNo compensationYn; //배상요청여부

}
