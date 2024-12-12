package com.promptoven.commissionservice.application;

import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.in.RequestModifyReqDto;
import com.promptoven.commissionservice.dto.out.CommissionListResponseDto;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import java.util.List;

public interface CommissionService {

    void createCommission(CreateCommissionRequestDto createCommissionRequestDto);

    CommissionResponseDto getCommissionDetails(String userUuid);

    List<CommissionListResponseDto> getCommissionList(String userUuid, String sortBy);

    void updateCommissionStatus(String commissionUuid, CommissionStatus status);

    void requestCommissionModify(RequestModifyReqDto requestModifyReqDto);
}
