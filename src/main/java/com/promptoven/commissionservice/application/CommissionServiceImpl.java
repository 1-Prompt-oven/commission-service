package com.promptoven.commissionservice.application;

import static com.promptoven.commissionservice.global.common.response.BaseResponseStatus.NO_EXIST_COMMISSION;
import static com.promptoven.commissionservice.global.common.response.BaseResponseStatus.NO_MATCHING_ROLE;

import com.promptoven.commissionservice.domain.Commission;
import com.promptoven.commissionservice.domain.Role;
import com.promptoven.commissionservice.domain.mapper.CommissionEntityMapper;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.mapper.CommissionDtoMapper;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import com.promptoven.commissionservice.global.error.BaseException;
import com.promptoven.commissionservice.infrastructure.CommissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService {

    private final CommissionRepository commissionRepository;
    private final CommissionDtoMapper commissionDtoMapper;
    private final CommissionEntityMapper commissionEntityMapper;

    @Override
    public void createCommission(CreateCommissionRequestDto createCommissionRequestDto) {
        commissionRepository.save(commissionDtoMapper.toCommission(createCommissionRequestDto));
    }

    @Override
    public CommissionResponseDto getCommissionDetails(String userUuid) {
        Commission commission = commissionRepository.findByClientUuidOrCreatorUuid(userUuid, userUuid)
                .orElseThrow(() -> new BaseException(NO_EXIST_COMMISSION));

        String role;
        if (userUuid.equals(commission.getClientUuid())) { role = Role.CLIENT.toString(); }
        else if (userUuid.equals(commission.getCreatorUuid())) { role = Role.CREATOR.toString(); }
        else { throw new BaseException(NO_MATCHING_ROLE); }

        String commissionModifyRequest = Role.CREATOR.toString().equals(role) ? commission.getCommissionModifyRequest() : null;

        return commissionEntityMapper.toCommissionResponseDto(commission, role, commissionModifyRequest);

    }
}
