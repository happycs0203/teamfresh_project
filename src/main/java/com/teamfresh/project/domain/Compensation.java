package com.teamfresh.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 배상 정보 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
public class Compensation extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensation_id")
    private int id; //배상번호

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voc_id")
    private Voc voc; //VOC

    private int compensationAmount; //배상금액

    @Enumerated(EnumType.STRING)
    private YesNo compensationYn; //배상요청여부

    public Compensation(Voc voc, int compensationAmount, YesNo compensationYn) {
        this.voc = voc;
        this.compensationAmount = compensationAmount;
        this.compensationYn = compensationYn;
    }
}
