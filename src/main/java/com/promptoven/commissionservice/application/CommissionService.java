package com.promptoven.commissionservice.application;

import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.in.GetDetailsRequestDto;
import com.promptoven.commissionservice.dto.in.RequestModifyReqDto;
import com.promptoven.commissionservice.dto.in.UploadResultRequestDto;
import com.promptoven.commissionservice.dto.out.CommissionListResponseDto;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import com.promptoven.commissionservice.dto.out.CreateCommissionResponseDto;
import java.util.List;

public interface CommissionService {

    CreateCommissionResponseDto createCommission(CreateCommissionRequestDto createCommissionRequestDto);

    CommissionResponseDto getCommissionDetails(GetDetailsRequestDto getDetailsRequestDto);

    List<CommissionListResponseDto> getCommissionList(String userUuid, String sortBy);

    void updateCommissionStatus(String commissionUuid, CommissionStatus status);

    void requestCommissionModify(RequestModifyReqDto requestModifyReqDto);

    void uploadResult(UploadResultRequestDto uploadResultRequestDto);
}
