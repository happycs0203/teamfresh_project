package com.teamfresh.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Penalty extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voc_id")
    private Voc voc;

    @Enumerated(EnumType.STRING)
    private YesNo confirmYn; //확인여부

    @Enumerated(EnumType.STRING)
    private YesNo appealYn; //이의제기여부

    public Penalty(Voc voc, YesNo confirmYn, YesNo appealYn) {
        this.voc = voc;
        this.confirmYn = confirmYn;
        this.appealYn = appealYn;
    }
}
