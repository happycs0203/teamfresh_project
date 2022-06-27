package com.teamfresh.project.service;

import com.teamfresh.project.api.dto.VocRequest;
import com.teamfresh.project.domain.dto.VocDto;

import java.util.List;

public interface VocService {


    List<VocDto> searchVocList();

    String createVoc(VocRequest vocRequest);
}
