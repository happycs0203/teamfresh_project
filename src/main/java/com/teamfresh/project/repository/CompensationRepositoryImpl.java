package com.teamfresh.project.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teamfresh.project.domain.dto.CompensationDto;
import com.teamfresh.project.domain.dto.QCompensationDto;

import javax.persistence.EntityManager;
import java.util.List;

import static com.teamfresh.project.domain.QCarrier.*;
import static com.teamfresh.project.domain.QCompensation.*;
import static com.teamfresh.project.domain.QCustomer.*;
import static com.teamfresh.project.domain.QVoc.*;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 정보 레포지토리 커스텀 구현
 */
public class CompensationRepositoryImpl implements CompensationRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CompensationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * @Desc 배상정보의 VOC 정보, 배상금액 정보 리스트
     * @return
     */
    @Override
    public List<CompensationDto> findCompensationList() {
        
        List<CompensationDto> compensationDtoList = queryFactory.select(new QCompensationDto(
                        compensation.id,
                        compensation.compensationAmount,
                        compensation.compensationYn,
                        voc.vocType,
                        voc.vocContent,
                        carrier.carrierCompany,
                        carrier.carrierName,
                        customer.customerCompany,
                        customer.customerName
                ))
                .from(compensation)
                .join(compensation.voc, voc)
                .join(voc.carrier, carrier)
                .join(voc.customer, customer)
                .fetch();

        return compensationDtoList;
    }
}
