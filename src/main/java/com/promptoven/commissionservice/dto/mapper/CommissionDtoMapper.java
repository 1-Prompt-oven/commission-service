package com.promptoven.commissionservice.dto.mapper;

import com.promptoven.commissionservice.domain.Commission;
import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.out.CommissionListResponseDto;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import com.promptoven.commissionservice.global.common.UuidGenerator;
import com.promptoven.commissionservice.vo.out.CommissionListResponseVo;
import com.promptoven.commissionservice.vo.out.CommissionResponseVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommissionDtoMapper {

    public Commission toCommission(CreateCommissionRequestDto createCommissionRequestDto) {
        return Commission.builder()
                .commissionUuid(UuidGenerator.generatePurchaseUuid())
                .clientUuid(createCommissionRequestDto.getClientUuid())
                .creatorUuid(createCommissionRequestDto.getCreatorUuid())
                .commissionTitle(createCommissionRequestDto.getCommissionTitle())
                .commissionDescription(createCommissionRequestDto.getCommissionDescription())
                .commissionPrice(createCommissionRequestDto.getCommissionPrice())
                .commissionDeadline(createCommissionRequestDto.getCommissionDeadline())
                .commissionModel(createCommissionRequestDto.getCommissionModel())
                .commissionRequest(createCommissionRequestDto.getCommissionRequest())
                .commissionStatus(CommissionStatus.REQUESTED)
                .build();
    }

    public CommissionResponseVo toCommissionResponseVo(CommissionResponseDto commissionResponseDto) {
        return CommissionResponseVo.builder()
                .commissionUuid(commissionResponseDto.getCommissionUuid())
                .clientUuid(commissionResponseDto.getClientUuid())
                .creatorUuid(commissionResponseDto.getCreatorUuid())
                .commissionTitle(commissionResponseDto.getCommissionTitle())
                .commissionDescription(commissionResponseDto.getCommissionDescription())
                .commissionPrice(commissionResponseDto.getCommissionPrice())
                .commissionDeadline(commissionResponseDto.getCommissionDeadline())
                .commissionModel(commissionResponseDto.getCommissionModel())
                .commissionRequest(commissionResponseDto.getCommissionRequest())
                .commissionModifyRequest(commissionResponseDto.getCommissionModifyRequest())
                .commissionStatus(commissionResponseDto.getCommissionStatus())
                .commissionModifyRequest(commissionResponseDto.getCommissionModifyRequest())
                .role(commissionResponseDto.getRole())
                .build();
    }

    public List<CommissionListResponseVo> toCommissionListResponseVo(List<CommissionListResponseDto> commissionListResponseDto) {
        return commissionListResponseDto.stream()
                .map(Dto -> CommissionListResponseVo.builder()
                        .commissionUuid(Dto.getCommissionUuid())
                        .clientUuid(Dto.getClientUuid())
                        .title(Dto.getTitle())
                        .price(Dto.getPrice())
                        .deadline(Dto.getDeadline())
                        .status(Dto.getStatus())
                        .requestedDate(Dto.getRequestedDate())
                        .build())
                .toList();
    }
}
