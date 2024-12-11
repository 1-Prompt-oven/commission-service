package com.promptoven.commissionservice.presentation;

import com.promptoven.commissionservice.application.CommissionService;
import com.promptoven.commissionservice.dto.in.CreateCommissionRequestDto;
import com.promptoven.commissionservice.dto.mapper.CommissionDtoMapper;
import com.promptoven.commissionservice.global.common.response.BaseResponse;
import com.promptoven.commissionservice.vo.in.CreateCommissionRequestVo;
import com.promptoven.commissionservice.vo.mapper.CommissionVoMapper;
import com.promptoven.commissionservice.vo.out.CommissionResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public BaseResponse<Void> createCommission(@RequestBody CreateCommissionRequestVo createCommissionRequestVo) {

        CreateCommissionRequestDto createCommissionRequestDto = commissionVoMapper.toCreateCommissionRequestDto(
                createCommissionRequestVo);

        commissionService.createCommission(createCommissionRequestDto);

        return new BaseResponse<>();
    }

    @GetMapping("/details/{userUuid}")
    public BaseResponse<CommissionResponseVo> getCommissionDetails(@PathVariable String userUuid) {

        return new BaseResponse<>(
                commissionDtoMapper.toCommissionResponseVo(commissionService.getCommissionDetails(userUuid)));
    }

    @GetMapping("/list/{userUuid}")
    public BaseResponse<Void> getCommissionList(@PathVariable String userUuid, @RequestParam(defaultValue = "Latest") String sortBy) {

        commissionService.getCommissionList(userUuid, sortBy);

        return new BaseResponse<>();
    }
}
