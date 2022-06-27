package com.teamfresh.project.api;

import com.teamfresh.project.api.dto.PenaltyRequest;
import com.teamfresh.project.api.dto.VocRequest;
import com.teamfresh.project.api.dto.common.DefaultResponse;
import com.teamfresh.project.api.dto.common.ResponseMessage;
import com.teamfresh.project.api.dto.common.Result;
import com.teamfresh.project.api.dto.common.StatusCode;
import com.teamfresh.project.domain.dto.VocDto;
import com.teamfresh.project.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 목록 API
 */
@RestController
@RequiredArgsConstructor
public class VocApiController {

    private final VocService vocService;

    @GetMapping("/vocs")
    public ResponseEntity searchVoc() {
        List<VocDto> vocDtoList = vocService.searchVocList();
        Result result = new Result(vocDtoList.size(), vocDtoList);
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.VOC_SUCCESS, result), HttpStatus.OK);
    }

    @PostMapping("/vocs")
    public ResponseEntity createVoc(@RequestBody VocRequest vocRequest){
        String message = vocService.createVoc(vocRequest);
        int statusCode = StatusCode.OK;
        if (!message.equals(ResponseMessage.PENALTY_OK)) {
            statusCode = StatusCode.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(DefaultResponse.res(statusCode, message, vocRequest), HttpStatus.OK);

    }

}
