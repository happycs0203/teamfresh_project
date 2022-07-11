package com.teamfresh.project.service;

import com.teamfresh.project.api.dto.VocRequest;
import com.teamfresh.project.domain.dto.VocDto;

import java.util.List;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 정보 서비스 인터페이스
 */
public interface VocService {


    List<VocDto> searchVocList();

    String createVoc(VocRequest vocRequest);
}
