package com.teamfresh.project.repository;

import com.teamfresh.project.domain.dto.VocDto;

import java.util.List;

public interface VocRepositoryCustom {
    List<VocDto> findVocList();
}
