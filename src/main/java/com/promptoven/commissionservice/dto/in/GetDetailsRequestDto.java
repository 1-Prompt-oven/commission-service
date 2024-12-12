package com.promptoven.commissionservice.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailsRequestDto {

    private String commissionUuid;
    private String userUuid;
}
