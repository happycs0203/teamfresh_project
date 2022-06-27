package com.teamfresh.project.api;

import com.teamfresh.project.api.dto.common.DefaultResponse;
import com.teamfresh.project.api.dto.common.ResponseMessage;
import com.teamfresh.project.api.dto.common.Result;
import com.teamfresh.project.api.dto.common.StatusCode;
import com.teamfresh.project.domain.dto.CompensationDto;
import com.teamfresh.project.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 목록 API
 */
@RestController
@RequiredArgsConstructor
public class CompensationApiController {

    private final CompensationService compensationService;

    @GetMapping("/compensations")
    public ResponseEntity searchCompensations() {

        List<CompensationDto> compensationDtoList = compensationService.searchCompensations();
        Result result = new Result(compensationDtoList.size(), compensationDtoList);
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.COMPENSATION_SUCCESS, result), HttpStatus.OK);
    }
}
