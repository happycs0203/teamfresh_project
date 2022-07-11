package com.teamfresh.project.service;

import com.teamfresh.project.api.dto.CarrierRequest;
import com.teamfresh.project.api.dto.CompensationRequest;
import com.teamfresh.project.api.dto.CustomerRequest;
import com.teamfresh.project.api.dto.PenaltyRequest;
import com.teamfresh.project.api.dto.common.ResponseMessage;
import com.teamfresh.project.domain.*;
import com.teamfresh.project.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 공통부분 서비스 로직
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final CustomerRepository customerRepository;
    private final CarrierRepository carrierRepository;
    private final PenaltyRepository penaltyRepository;
    private final VocRepository vocRepository;
    private final CompensationRepository compensationRepository;

    /**
     * 고객사 등록 로직
     * @param customerRequest
     * @return
     */
    @Transactional
    @Override
    public String createCustomer(CustomerRequest customerRequest) {
        try {
            Customer customer = new Customer(customerRequest);
            customerRepository.save(customer);
        } catch (Exception e) {
            return ResponseMessage.CUSTOMER_FAIL;
        }
        return ResponseMessage.CUSTOMER_OK;
    }

    /**
     * 운송사기사 등록 로직
     * @param carrierRequest
     * @return
     */
    @Transactional
    @Override
    public String createCarrier(CarrierRequest carrierRequest) {

        try {
            Carrier carrier = new Carrier(carrierRequest);
            carrierRepository.save(carrier);
        } catch (Exception e) {
            return ResponseMessage.CARRIER_FAIL;
        }

        return ResponseMessage.CARRIER_OK;
    }

    /**
     * 페널티 등록 로직
     * @param penaltyRequest
     * @return
     */
    @Transactional
    @Override
    public String createPenalty(PenaltyRequest penaltyRequest) {

        Optional<Voc> byId = vocRepository.findById(penaltyRequest.getVocId());
        if (byId.isPresent()) {
            try {
                Voc voc = byId.get();
                Penalty penalty = new Penalty(voc, penaltyRequest.getConfirmYn(), penaltyRequest.getAppealYn());
                penaltyRepository.save(penalty);
            } catch (Exception e) {
                return ResponseMessage.PENALTY_FAIL;
            }
        }else{
            return ResponseMessage.VOC_NOT_FOUND;
        }
        return ResponseMessage.PENALTY_OK;
    }

    /**
     * 배상등록로직
     * @param compensationRequest
     * @return
     */
    @Transactional
    @Override
    public String createCompensation(CompensationRequest compensationRequest) {
        Optional<Voc> byId = vocRepository.findById(compensationRequest.getVocId());
        if (byId.isPresent()) {
            try {
                Voc voc = byId.get();
                Compensation compensation = new Compensation(voc, compensationRequest.getCompensationAmount(), compensationRequest.getCompensationYn());
                compensationRepository.save(compensation);
            } catch (Exception e) {
                return ResponseMessage.COMPENSATION_FAIL;
            }

        }else{
            return ResponseMessage.VOC_NOT_FOUND;
        }

        return ResponseMessage.COMPENSATION_OK;
    }
}
