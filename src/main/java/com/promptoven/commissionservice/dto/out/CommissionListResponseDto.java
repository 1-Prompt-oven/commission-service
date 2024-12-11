package com.promptoven.commissionservice.dto.out;

import com.promptoven.commissionservice.domain.CommissionStatus;
import java.time.LocalDateTime;

public class CommissionListResponseDto {
    
    private String title;
    private String clientUuid;
    private Long price;
    private LocalDateTime deadline;
    private CommissionStatus status;
    private LocalDateTime requestedDate;
}
