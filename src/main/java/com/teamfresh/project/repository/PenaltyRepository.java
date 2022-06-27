package com.teamfresh.project.repository;

import com.teamfresh.project.domain.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {
}
