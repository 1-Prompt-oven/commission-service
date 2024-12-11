package com.promptoven.commissionservice.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommissionResponseDto {

    private String commissionUuid;
    private String clientUuid;
    private String creatorUuid;
    private String commissionTitle;
    private String commissionDescription;
    private String commissionPrice;
    private String commissionDeadline;
    private String commissionModel;
    private String commissionRequest;
    private String commissionStatus;
}
