package com.teamfresh.project.service;

import com.teamfresh.project.domain.dto.CompensationDto;
import com.teamfresh.project.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 정보 서비스 구현
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompensationServiceImpl implements CompensationService {

    private final CompensationRepository compensationRepository;

    @Override
    public List<CompensationDto> searchCompensations() {
        List<CompensationDto> compensationDtoList = compensationRepository.findCompensationList();
        return compensationDtoList;
    }
}
