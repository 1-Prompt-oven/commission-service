package com.promptoven.commissionservice.application;

import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;

public interface CommissionService {

    void createCommission(CreateCommissionRequestDto createCommissionRequestDto);
}
