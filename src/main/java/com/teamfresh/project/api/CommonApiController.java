package com.teamfresh.project.api;

import com.teamfresh.project.api.dto.CarrierRequest;
import com.teamfresh.project.api.dto.CompensationRequest;
import com.teamfresh.project.api.dto.CustomerRequest;
import com.teamfresh.project.api.dto.PenaltyRequest;
import com.teamfresh.project.api.dto.common.DefaultResponse;
import com.teamfresh.project.api.dto.common.ResponseMessage;
import com.teamfresh.project.api.dto.common.StatusCode;
import com.teamfresh.project.domain.Carrier;
import com.teamfresh.project.domain.Compensation;
import com.teamfresh.project.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 등록
 * 패널티 등록
 * 배송기사의 패널티 확인 여부 등록
 * 배상정보 등록
 */
@RestController
@RequiredArgsConstructor
public class CommonApiController {

    private final CommonService commonService;

    /**
     * 고객사정보 등록 API
     * @param customerRequest
     * @return
     */
    @PostMapping("/customers")
    public ResponseEntity createCustomer(@RequestBody CustomerRequest customerRequest) {
        String message = commonService.createCustomer(customerRequest);
        int statusCode = StatusCode.OK;
        if (!message.equals(ResponseMessage.CUSTOMER_OK)) {
            statusCode = StatusCode.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(DefaultResponse.res(statusCode, message, customerRequest), HttpStatus.OK);
    }

    /**
     * 운송사기사정보 등록 API
     * @param carrierRequest
     * @return
     */
    @PostMapping("/carriers")
    public ResponseEntity createCarrier(@RequestBody CarrierRequest carrierRequest) {
        String message = commonService.createCarrier(carrierRequest);
        int statusCode = StatusCode.OK;
        if (!message.equals(ResponseMessage.CARRIER_OK)) {
            statusCode = StatusCode.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity(DefaultResponse.res(statusCode, message, carrierRequest), HttpStatus.OK);
    }


    /**
     * 배송기사의 패널티 확인 여부 등록 API
     * @param penaltyRequest
     * @return
     */
    @PostMapping("/penalties")
    public ResponseEntity createPenalty(@RequestBody PenaltyRequest penaltyRequest) {
        String message = commonService.createPenalty(penaltyRequest);
        int statusCode = StatusCode.OK;
        if (!message.equals(ResponseMessage.PENALTY_OK)) {
            statusCode = StatusCode.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(DefaultResponse.res(statusCode, message, penaltyRequest), HttpStatus.OK);
    }


    /**
     * 배상 등록 API
     * @param compensationRequest
     * @return
     */
    @PostMapping("/compensations")
    public ResponseEntity createCompensation(@RequestBody CompensationRequest compensationRequest) {
        String message = commonService.createCompensation(compensationRequest);
        int statusCode = StatusCode.OK;
        if (!message.equals(ResponseMessage.COMPENSATION_OK)) {
            statusCode = StatusCode.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(DefaultResponse.res(statusCode, message, compensationRequest), HttpStatus.OK);

    }
}
