package com.teamfresh.project.repository;

import com.teamfresh.project.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 고객사 레포지토리 인터페이스
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
