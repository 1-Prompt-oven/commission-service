package com.promptoven.commissionservice.application;

import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.mapper.CommissionDtoMapper;
import com.promptoven.commissionservice.infrastructure.CommissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService {

    private final CommissionRepository commissionRepository;
    private final CommissionDtoMapper commissionDtoMapper;

    @Override
    public void createCommission(CreateCommissionRequestDto createCommissionRequestDto) {
        commissionRepository.save(commissionDtoMapper.toCommission(createCommissionRequestDto));
    }
}
