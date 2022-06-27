package com.teamfresh.project.repository;

import com.teamfresh.project.domain.Voc;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 정보 레포지토리
 */
public interface VocRepository extends JpaRepository<Voc, Integer>, VocRepositoryCustom {

}
