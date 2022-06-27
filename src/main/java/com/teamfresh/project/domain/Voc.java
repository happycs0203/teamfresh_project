package com.teamfresh.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc VOC 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
public class Voc extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private int id; //voc번호

    @Enumerated(EnumType.STRING)
    private VocType vocType; //귀책당사자

    private String vocContent; //귀책내용

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "voc")
    private Penalty penalty;

    @OneToOne(mappedBy = "voc")
    private Compensation compensation;

    public Voc(VocType vocType, String vocContent, Carrier carrier, Customer customer) {
        this.vocType = vocType;
        this.vocContent = vocContent;
        this.carrier = carrier;
        this.customer = customer;
    }
}
