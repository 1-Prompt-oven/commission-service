package com.promptoven.commissionservice.domain.mapper;

import com.promptoven.commissionservice.domain.Commission;
import com.promptoven.commissionservice.domain.Role;
import com.promptoven.commissionservice.dto.out.CommissionListResponseDto;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import com.promptoven.commissionservice.dto.out.CreateCommissionResponseDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CommissionEntityMapper {

    public CommissionResponseDto toCommissionResponseDto(Commission commission, Role role) {
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
                .commissionModifyRequest(commission.getCommissionModifyRequest())
                .commissionResult(commission.getCommissionResult())
                .build();
    }

    public List<CommissionListResponseDto> toCommissionListResponseDto(List<Commission> commissions) {
        return commissions.stream()
                .map(commission -> CommissionListResponseDto.builder()
                        .commissionUuid(commission.getCommissionUuid())
                        .clientUuid(commission.getClientUuid())
                        .title(commission.getCommissionTitle())
                        .price(commission.getCommissionPrice())
                        .deadline(commission.getCommissionDeadline())
                        .status(commission.getCommissionStatus())
                        .requestedDate(commission.getCreatedDate())
                        .build())
                .toList();
    }

    public CreateCommissionResponseDto toCreateCommissionResponseDto(Commission commission) {
        return CreateCommissionResponseDto.builder()
                .commissionUuid(commission.getCommissionUuid())
                .build();
    }
}
