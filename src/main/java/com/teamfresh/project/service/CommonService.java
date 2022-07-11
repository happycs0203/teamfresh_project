package com.teamfresh.project.service;

import com.teamfresh.project.api.dto.CarrierRequest;
import com.teamfresh.project.api.dto.CompensationRequest;
import com.teamfresh.project.api.dto.CustomerRequest;
import com.teamfresh.project.api.dto.PenaltyRequest;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 공통부분 서비스 인터페이스
 */
public interface CommonService {
    String createCustomer(CustomerRequest customerRequest);

    String createCarrier(CarrierRequest carrierRequest);

    String createPenalty(PenaltyRequest penaltyRequest);

    String createCompensation(CompensationRequest compensationRequest);
}
