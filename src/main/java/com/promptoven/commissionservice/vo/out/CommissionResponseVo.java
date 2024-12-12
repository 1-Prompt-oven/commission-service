package com.promptoven.commissionservice.vo.out;

import com.promptoven.commissionservice.domain.CommissionStatus;
import com.promptoven.commissionservice.domain.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommissionResponseVo {

    private String commissionUuid;
    private String clientUuid;
    private String creatorUuid;
    private String commissionTitle;
    private String commissionDescription;
    private Long commissionPrice;
    private LocalDate commissionDeadline;
    private String commissionModel;
    private String commissionRequest;
    private String commissionModifyRequest;
    private CommissionStatus commissionStatus;
    private String commissionResult;
    private Role role;
}
