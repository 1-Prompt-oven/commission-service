package com.promptoven.commissionservice.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UploadResultRequestDto {

    private String commissionUuid;
    private String commissionResult;
}
