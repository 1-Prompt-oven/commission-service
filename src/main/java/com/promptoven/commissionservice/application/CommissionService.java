package com.promptoven.commissionservice.application;

import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;

public interface CommissionService {

    void createCommission(CreateCommissionRequestDto createCommissionRequestDto);

    CommissionResponseDto getCommissionDetails(String userUuid);
}
