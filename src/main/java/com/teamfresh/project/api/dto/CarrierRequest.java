package com.teamfresh.project.api.dto;

import lombok.Data;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 운송기사 리퀘스트
 */
@Data
public class CarrierRequest {

    private String carrierCompany; //운송사명

    private String carrierName; //이름

    private String carrierPhone; //연락처
}
