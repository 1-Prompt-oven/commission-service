package com.promptoven.commissionservice.presentation;

import com.promptoven.commissionservice.application.CommissionService;
import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.dto.in.GetDetailsRequestDto;
import com.promptoven.commissionservice.dto.mapper.CommissionDtoMapper;
import com.promptoven.commissionservice.dto.out.CommissionListResponseDto;
import com.promptoven.commissionservice.dto.out.CreateCommissionResponseDto;
import com.promptoven.commissionservice.global.common.response.BaseResponse;
import com.promptoven.commissionservice.vo.in.CreateCommissionRequestVo;
import com.promptoven.commissionservice.vo.in.GetDetailsRequestVo;
import com.promptoven.commissionservice.vo.in.RequestModifyReqVo;
import com.promptoven.commissionservice.vo.in.UploadResultRequestVo;
import com.promptoven.commissionservice.vo.mapper.CommissionVoMapper;
import com.promptoven.commissionservice.vo.out.CommissionListResponseVo;
import com.promptoven.commissionservice.vo.out.CommissionResponseVo;
import com.promptoven.commissionservice.vo.out.CreateCommissionResponseVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/member/commission")
@RequiredArgsConstructor
public class CommissionController {

    private final CommissionService commissionService;
    private final CommissionVoMapper commissionVoMapper;
    private final CommissionDtoMapper commissionDtoMapper;

    @PostMapping
    public BaseResponse<CreateCommissionResponseVo> createCommission(
            @RequestBody CreateCommissionRequestVo createCommissionRequestVo) {

        CreateCommissionResponseDto commissionResponseDto = commissionService.createCommission(
                commissionVoMapper.toCreateCommissionRequestDto(createCommissionRequestVo));

        return new BaseResponse<>(commissionDtoMapper.toCreateCommissionResponseVo(commissionResponseDto));
    }

    @GetMapping("/details")
    public BaseResponse<CommissionResponseVo> getCommissionDetails(@RequestBody GetDetailsRequestVo getDetailsRequestVo) {

        GetDetailsRequestDto getDetailsRequestDto = commissionVoMapper.toGetDetailsRequestDto(getDetailsRequestVo);

        return new BaseResponse<>(commissionDtoMapper.toCommissionResponseVo(
                commissionService.getCommissionDetails(getDetailsRequestDto))
        );
    }

    @GetMapping("/list/{userUuid}")
    public BaseResponse<List<CommissionListResponseVo>> getCommissionList(@PathVariable String userUuid,
            @RequestParam(defaultValue = "Latest") String sortBy) {

        List<CommissionListResponseDto> commissionListResponseDtoList = commissionService.getCommissionList(userUuid,
                sortBy);

        return new BaseResponse<>(commissionDtoMapper.toCommissionListResponseVo(commissionListResponseDtoList));
    }

    @PutMapping("/statusUpdate/{commissionUuid}")
    public BaseResponse<Void> updateCommissionStatus(@PathVariable String commissionUuid,
            @RequestParam CommissionStatus status) {

        commissionService.updateCommissionStatus(commissionUuid, status);

        return new BaseResponse<>();
    }

    @PutMapping("/requestModify")
    public BaseResponse<Void> requestCommissionModify(@RequestBody RequestModifyReqVo requestModifyReqVo) {

        commissionService.requestCommissionModify(commissionVoMapper.toRequestModifyReqDto(requestModifyReqVo));

        return new BaseResponse<>();
    }

    @PostMapping("/uploadResult")
    public BaseResponse<Void> uploadResult(@RequestBody UploadResultRequestVo uploadResultRequestVo) {

        commissionService.uploadResult(commissionVoMapper.toUploadResultRequestDto(uploadResultRequestVo));

        return new BaseResponse<>();
    }
}
