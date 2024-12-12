package com.promptoven.commissionservice.domain;

import com.promptoven.commissionservice.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Commission extends BaseEntity {

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
    private LocalDate commissionDeadline;

    @Column(nullable = false)
    private String commissionModel;

    @Column
    private String commissionRequest;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommissionStatus commissionStatus;

    @Column
    private String commissionModifyRequest;
}
