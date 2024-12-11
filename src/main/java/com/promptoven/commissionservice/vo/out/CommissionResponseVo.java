package com.promptoven.commissionservice.vo.out;

import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommissionResponseVo {

    private String commissionUuid;
    private String clientUuid;
    private String creatorUuid;
    private String commissionTitle;
    private String commissionDescription;
    private Long commissionPrice;
    private String commissionDeadline;
    private String commissionModel;
    private String commissionRequest;
    private String commissionModifyRequest;
    private CommissionStatus commissionStatus;
    private Role role;
}
