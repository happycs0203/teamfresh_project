package com.teamfresh.project.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teamfresh.project.domain.dto.QVocDto;
import com.teamfresh.project.domain.dto.VocDto;

import javax.persistence.EntityManager;
import java.util.List;

import static com.teamfresh.project.domain.QCompensation.*;
import static com.teamfresh.project.domain.QPenalty.*;
import static com.teamfresh.project.domain.QVoc.*;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 정보 레포지토리 커스텀 구현
 */
public class VocRepositoryImpl implements VocRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public VocRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * @Desc VOC의 귀책 당사자, 귀책 내용, 패널티 내용, 기사 확인 여부, 이의제기 여부, 배상정보 등의 정보 조회
     * @return
     */
    @Override
    public List<VocDto> findVocList() {
        List<VocDto> vocDtoList = queryFactory.select(new QVocDto(
                        voc.vocType,
                        voc.vocContent,
                        compensation.compensationAmount,
                        compensation.compensationYn,
                        penalty.confirmYn,
                        penalty.appealYn
                ))
                .from(voc)
                .join(voc.penalty, penalty)
                .join(voc.compensation, compensation)
                .fetch();

        return vocDtoList;
    }
}
