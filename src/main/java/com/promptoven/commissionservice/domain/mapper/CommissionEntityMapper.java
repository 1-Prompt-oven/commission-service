package com.promptoven.commissionservice.domain.mapper;

import com.promptoven.commissionservice.domain.Commission;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CommissionEntityMapper {

    public CommissionResponseDto toCommissionResponseDto(Commission commission, String role,
            String commissionModifyRequest) {
        return CommissionResponseDto.builder()
                .commissionUuid(commission.getCommissionUuid())
                .clientUuid(commission.getClientUuid())
                .creatorUuid(commission.getCreatorUuid())
                .commissionTitle(commission.getCommissionTitle())
                .commissionDescription(commission.getCommissionDescription())
                .commissionPrice(commission.getCommissionPrice())
                .commissionDeadline(commission.getCommissionDeadline())
                .commissionModel(commission.getCommissionModel())
                .commissionRequest(commission.getCommissionRequest())
                .commissionModifyRequest(commission.getCommissionModifyRequest())
                .commissionStatus(commission.getCommissionStatus())
                .role(role)
                .commissionModifyRequest(commissionModifyRequest)
                .build();
    }
}
