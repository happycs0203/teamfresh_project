package com.teamfresh.project.domain;

import com.teamfresh.project.api.dto.CustomerRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ChangSu, Ham
 * @version 1.0
 * @Desc 고객사 정보 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
public class Customer extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id; //고객사번호

    private String customerCompany; //고객사명

    private String customerName; //고객사담당자이름

    private String customerPhone; //연락처

    public Customer(CustomerRequest customerRequest) {
        this.customerCompany = customerRequest.getCustomerCompany();
        this.customerName = customerRequest.getCustomerName();
        this.customerPhone = customerRequest.getCustomerPhone();
    }
}
