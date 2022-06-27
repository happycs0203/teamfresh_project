package com.teamfresh.project.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.teamfresh.project.domain.VocType;
import com.teamfresh.project.domain.YesNo;
import lombok.Data;

@Data
public class CompensationDto {

    private int compensationId;
    private int compensationAmount;
    private YesNo compensationYn;
    private VocType vocType;
    private String vocContent;
    private String carrierCompany;
    private String carrierName;
    private String customerCompany;
    private String customerName;

    @QueryProjection
    public CompensationDto(int compensationId, int compensationAmount, YesNo compensationYn, VocType vocType, String vocContent, String carrierCompany, String carrierName, String customerCompany, String customerName) {
        this.compensationId = compensationId;
        this.compensationAmount = compensationAmount;
        this.compensationYn = compensationYn;
        this.vocType = vocType;
        this.vocContent = vocContent;
        this.carrierCompany = carrierCompany;
        this.carrierName = carrierName;
        this.customerCompany = customerCompany;
        this.customerName = customerName;
    }
}
