package com.teamfresh.project.api.dto;

import com.teamfresh.project.domain.VocType;
import lombok.Data;

@Data
public class VocRequest {

    private VocType vocType; //귀책당사자

    private String vocContent; //귀책내용

    private int carrierId; //운송사기사번호

    private int customerId; //고객사번호

}
