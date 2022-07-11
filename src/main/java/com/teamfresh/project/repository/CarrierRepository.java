package com.teamfresh.project.repository;

import com.teamfresh.project.domain.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 운송사 레포지토리 인터페이스
 */
public interface CarrierRepository extends JpaRepository<Carrier, Integer> {
}
