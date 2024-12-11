package com.promptoven.commissionservice.vo.mapper;

import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.vo.in.CreateCommissionRequestVo;
import org.springframework.stereotype.Component;

@Component
public class CommissionVoMapper {
    public CreateCommissionRequestDto toCreateCommissionRequestDto(CreateCommissionRequestVo createCommissionRequestVo) {
        return CreateCommissionRequestDto.builder()
                .commissionTitle(createCommissionRequestVo.getCommissionTitle())
                .clientUuid(createCommissionRequestVo.getClientUuid())
                .creatorUuid(createCommissionRequestVo.getCreatorUuid())
                .commissionDescription(createCommissionRequestVo.getCommissionDescription())
                .commissionPrice(createCommissionRequestVo.getCommissionPrice())
                .commissionDeadline(createCommissionRequestVo.getCommissionDeadline())
                .commissionModel(createCommissionRequestVo.getCommissionModel())
                .commissionRequest(createCommissionRequestVo.getCommissionRequest())
                .build();
    }
}
