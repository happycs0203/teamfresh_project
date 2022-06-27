package com.teamfresh.project.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.teamfresh.project.domain.VocType;
import com.teamfresh.project.domain.YesNo;
import lombok.Data;

@Data
public class VocDto {

    private VocType vocType;
    private String vocContent;
    private int compensationAmount;
    private YesNo compensationYn;
    private YesNo confirmYn;
    private YesNo appealYn;

    @QueryProjection
    public VocDto(VocType vocType, String vocContent, int compensationAmount, YesNo compensationYn, YesNo confirmYn, YesNo appealYn) {
        this.vocType = vocType;
        this.vocContent = vocContent;
        this.compensationAmount = compensationAmount;
        this.compensationYn = compensationYn;
        this.confirmYn = confirmYn;
        this.appealYn = appealYn;
    }
}
