package com.teamfresh.project.service;

import com.teamfresh.project.domain.dto.CompensationDto;

import java.util.List;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 정보 서비스 인터페이스
 */
public interface CompensationService {
    List<CompensationDto> searchCompensations();
}
