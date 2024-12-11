package com.promptoven.commissionservice.presentation;

import com.promptoven.commissionservice.application.CommissionService;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.global.common.response.BaseResponse;
import com.promptoven.commissionservice.global.common.response.BaseResponseStatus;
import com.promptoven.commissionservice.vo.in.CreateCommissionRequestVo;
import com.promptoven.commissionservice.vo.mapper.CommissionVoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/member/commission")
@RequiredArgsConstructor
public class CommissionController {

    private final CommissionService commissionService;
    private final CommissionVoMapper commissionVoMapper;

    @PostMapping
    public BaseResponse<Void> createCommission(@RequestBody CreateCommissionRequestVo createCommissionRequestVo) {

        CreateCommissionRequestDto createCommissionRequestDto = commissionVoMapper.toCreateCommissionRequestDto(
                createCommissionRequestVo);

        commissionService.createCommission(createCommissionRequestDto);

        return new BaseResponse<>();
    }
}
