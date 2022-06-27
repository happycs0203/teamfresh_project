package com.teamfresh.project.repository;

import com.teamfresh.project.domain.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 정보 레포지토리
 */
public interface CompensationRepository extends JpaRepository<Compensation, Integer>, CompensationRepositoryCustom{

}
