package com.promptoven.commissionservice.vo.in;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CreateCommissionRequestVo {

    private String commissionTitle;
    private String clientUuid;
    private String creatorUuid;
    private String commissionDescription;
    private Long commissionPrice;
    private LocalDate commissionDeadline;
    private String commissionModel;
    private String commissionRequest;
    private String commissionModifyRequest;

}