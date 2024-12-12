package com.promptoven.commissionservice.application;

import static com.promptoven.commissionservice.global.common.response.BaseResponseStatus.NO_EXIST_COMMISSION;
import static com.promptoven.commissionservice.global.common.response.BaseResponseStatus.NO_MATCHING_ROLE;

import com.promptoven.commissionservice.domain.Commission;
import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.domain.Role;
import com.promptoven.commissionservice.domain.mapper.CommissionEntityMapper;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.in.GetDetailsRequestDto;
import com.promptoven.commissionservice.dto.in.RequestModifyReqDto;
import com.promptoven.commissionservice.dto.in.UploadResultRequestDto;
import com.promptoven.commissionservice.dto.mapper.CommissionDtoMapper;
import com.promptoven.commissionservice.dto.out.CommissionListResponseDto;
import com.promptoven.commissionservice.dto.out.CommissionResponseDto;
import com.promptoven.commissionservice.global.error.BaseException;
import com.promptoven.commissionservice.infrastructure.CommissionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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
    public CommissionResponseDto getCommissionDetails(GetDetailsRequestDto getDetailsRequestDto) {

        String userUuid = getDetailsRequestDto.getUserUuid();

        Commission commission = commissionRepository.findByCommissionUuid(getDetailsRequestDto.getCommissionUuid())
                .orElseThrow(() -> new BaseException(NO_EXIST_COMMISSION));

        Role role;
        if (userUuid.equals(commission.getClientUuid())) {
            role = Role.CLIENT;
        } else if (userUuid.equals(commission.getCreatorUuid())) {
            role = Role.CREATOR;
        } else {
            throw new BaseException(NO_MATCHING_ROLE);
        }

        String commissionModifyRequest = Role.CREATOR.equals(role) ? commission.getCommissionModifyRequest() : null;

        return commissionEntityMapper.toCommissionResponseDto(commission, role, commissionModifyRequest);
    }

    @Override
    public List<CommissionListResponseDto> getCommissionList(String userUuid, String sortBy) {

        Sort sort = switch (sortBy) {
            case "Price" -> Sort.by(Sort.Order.desc("commissionPrice"));
            case "Deadline" -> Sort.by(Sort.Order.asc("commissionDeadline"));
            default -> Sort.by(Sort.Order.desc("createdDate"));
        };

        List<Commission> commissions = commissionRepository.findByClientUuidOrCreatorUuid(userUuid, userUuid, sort);

        return commissionEntityMapper.toCommissionListResponseDto(commissions);

    }

    @Override
    public void updateCommissionStatus(String commissionUuid, CommissionStatus status) {
        Commission commission = commissionRepository.findByCommissionUuid(commissionUuid)
                .orElseThrow(() -> new BaseException(NO_EXIST_COMMISSION));

        Commission updatedCommission = Commission.builder()
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
                .commissionStatus(status)
                .commissionResult(commission.getCommissionResult())
                .build();

        commissionRepository.save(updatedCommission);
    }

    @Override
    public void requestCommissionModify(RequestModifyReqDto requestModifyReqDto) {
        Commission commission = commissionRepository.findByCommissionUuid(requestModifyReqDto.getCommissionUuid())
                .orElseThrow(() -> new BaseException(NO_EXIST_COMMISSION));

        Commission updatedCommission = Commission.builder()
                .commissionUuid(commission.getCommissionUuid())
                .clientUuid(commission.getClientUuid())
                .creatorUuid(commission.getCreatorUuid())
                .commissionTitle(commission.getCommissionTitle())
                .commissionDescription(commission.getCommissionDescription())
                .commissionPrice(commission.getCommissionPrice())
                .commissionDeadline(commission.getCommissionDeadline())
                .commissionModel(commission.getCommissionModel())
                .commissionRequest(commission.getCommissionRequest())
                .commissionStatus(commission.getCommissionStatus())
                .commissionModifyRequest(requestModifyReqDto.getCommissionModifyRequest())
                .commissionResult(commission.getCommissionResult())
                .build();

        commissionRepository.save(updatedCommission);
    }

    @Override
    public void uploadResult(UploadResultRequestDto uploadResultRequestDto) {
        Commission commission = commissionRepository.findByCommissionUuid(uploadResultRequestDto.getCommissionUuid())
                .orElseThrow(() -> new BaseException(NO_EXIST_COMMISSION));

        Commission updatedCommission = Commission.builder()
                .commissionUuid(commission.getCommissionUuid())
                .clientUuid(commission.getClientUuid())
                .creatorUuid(commission.getCreatorUuid())
                .commissionTitle(commission.getCommissionTitle())
                .commissionDescription(commission.getCommissionDescription())
                .commissionPrice(commission.getCommissionPrice())
                .commissionDeadline(commission.getCommissionDeadline())
                .commissionModel(commission.getCommissionModel())
                .commissionRequest(commission.getCommissionRequest())
                .commissionStatus(commission.getCommissionStatus())
                .commissionModifyRequest(commission.getCommissionModifyRequest())
                .commissionResult(uploadResultRequestDto.getCommissionResult())
                .build();

        commissionRepository.save(updatedCommission);
    }
}
