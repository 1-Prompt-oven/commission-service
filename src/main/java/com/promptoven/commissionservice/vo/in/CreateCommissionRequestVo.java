package com.promptoven.commissionservice.vo.in;

import lombok.Getter;

@Getter
public class CreateCommissionRequestVo {

    private String commissionTitle;
    private String clientUuid;
    private String creatorUuid;
    private String commissionDescription;
    private Long commissionPrice;
    private String commissionDeadline;
    private String commissionModel;
    private String commissionRequest;

}