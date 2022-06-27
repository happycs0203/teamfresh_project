package com.teamfresh.project.repository;

import com.teamfresh.project.domain.dto.CompensationDto;

import java.util.List;

public interface CompensationRepositoryCustom {
    List<CompensationDto> findCompensationList();
}
