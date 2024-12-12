package com.promptoven.commissionservice.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestModifyReqDto {
    private String commissionUuid;
    private String commissionModifyRequest;
}
