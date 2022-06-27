package com.teamfresh.project.api.dto;

import lombok.Data;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 고객사 정보 리퀘스트
 */
@Data
public class CustomerRequest {

    private String customerCompany; //고객사명

    private String customerName; //고객사담당자이름

    private String customerPhone; //연락처
}
