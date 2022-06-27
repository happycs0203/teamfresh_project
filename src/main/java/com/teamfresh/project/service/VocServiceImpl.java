package com.teamfresh.project.service;

import com.teamfresh.project.api.dto.VocRequest;
import com.teamfresh.project.api.dto.common.ResponseMessage;
import com.teamfresh.project.domain.Carrier;
import com.teamfresh.project.domain.Customer;
import com.teamfresh.project.domain.Voc;
import com.teamfresh.project.domain.dto.VocDto;
import com.teamfresh.project.repository.CarrierRepository;
import com.teamfresh.project.repository.CustomerRepository;
import com.teamfresh.project.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 정보 서비스 구현
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VocServiceImpl implements VocService{

    private final VocRepository vocRepository;
    private final CustomerRepository customerRepository;
    private final CarrierRepository carrierRepository;

    /**
     * VOC 조회 로직
     * @return
     */
    @Override
    public List<VocDto> searchVocList() {
        List<VocDto> vocDtoList = vocRepository.findVocList();
        return vocDtoList;
    }

    /**
     * VOC 입력 로직
     * @param vocRequest
     * @return
     */
    @Transactional
    @Override
    public String createVoc(VocRequest vocRequest) {

        Optional<Customer> findCustomer = customerRepository.findById(vocRequest.getCustomerId());
        Optional<Carrier> findCarrier = carrierRepository.findById(vocRequest.getCarrierId());

        if (findCarrier.isPresent() && findCustomer.isPresent()) {
            try {
                Carrier carrier = findCarrier.get();
                Customer customer = findCustomer.get();
                Voc voc = new Voc(vocRequest.getVocType(), vocRequest.getVocContent(), carrier, customer);
                vocRepository.save(voc);
            } catch (Exception e) {
                return ResponseMessage.VOC_FAIL;
            }

        } else if(!findCarrier.isPresent()){
            return ResponseMessage.CARRIER_NOT_FOUND;
        } else if(!findCustomer.isPresent()){
            return ResponseMessage.CUSTOMER_NOT_FOUND;
        } else {
            return ResponseMessage.VOC_FAIL;
        }
        return ResponseMessage.VOC_OK;
    }
}
