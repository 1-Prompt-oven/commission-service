package com.promptoven.commissionservice.dto.out;

import com.promptoven.commissionservice.domain.CommissionStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommissionListResponseDto {

    private String commissionUuid;
    private String title;
    private String clientUuid;
    private Long price;
    private LocalDate deadline;
    private CommissionStatus status;
    private LocalDateTime requestedDate;
}
