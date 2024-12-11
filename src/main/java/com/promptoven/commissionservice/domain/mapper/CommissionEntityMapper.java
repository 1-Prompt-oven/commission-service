package com.promptoven.commissionservice.domain.mapper;

import com.promptoven.commissionservice.domain.Commission;
import com.promptoven.commissionservice.domain.Role;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CommissionEntityMapper {

    public CommissionResponseDto toCommissionResponseDto(Commission commission, Role role,
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

//    public List<>
}
