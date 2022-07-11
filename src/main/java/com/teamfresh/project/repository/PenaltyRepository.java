package com.teamfresh.project.repository;

import com.teamfresh.project.domain.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 패널티 레포지토리 인터페이스
 */
public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {
}
