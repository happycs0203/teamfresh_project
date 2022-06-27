package com.teamfresh.project.service;

import com.teamfresh.project.domain.dto.CompensationDto;

import java.util.List;

public interface CompensationService {
    List<CompensationDto> searchCompensations();
}
