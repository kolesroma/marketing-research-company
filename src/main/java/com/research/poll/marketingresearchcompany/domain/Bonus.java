package com.research.poll.marketingresearchcompany.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "bonus")
@Data
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bonus_id")
    private Long bonusId;

    @ManyToOne
    @JoinColumn(name = "respondent_id", nullable = false)
    private Respondent respondent;

    @Column(name = "bonus_count", nullable = false)
    private int bonusCount;
}
