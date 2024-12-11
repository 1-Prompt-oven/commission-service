package com.promptoven.commissionservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "commission")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commission {

    @Id
    private String commissionUuid;

    @Column(nullable = false)
    private String clientUuid;

    @Column(nullable = false)
    private String creatorUuid;

    @Column(nullable = false)
    private String commissionTitle;

    @Column(nullable = false)
    private String commissionDescription;

    @Column(nullable = false)
    private Long commissionPrice;

    @Column(nullable = false)
    private String commissionDeadline;

    @Column(nullable = false)
    private String commissionModel;

    @Column
    private String commissionRequest;

    @Column(nullable = false)
    private String commissionStatus;

    @Column
    private String commissionModifyRequest;

}
