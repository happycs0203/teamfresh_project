package com.teamfresh.project.domain;

import com.teamfresh.project.api.dto.CarrierRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 운송사기사 정보 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
public class Carrier extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrier_id")
    private int id; //운송사기사번호

    private String carrierCompany; //운송사명

    private String carrierName; //이름

    private String carrierPhone; //연락처

    public Carrier(CarrierRequest carrierRequest) {
        this.carrierCompany = carrierRequest.getCarrierCompany();
        this.carrierName = carrierRequest.getCarrierName();
        this.carrierPhone = carrierRequest.getCarrierPhone();
    }
}
