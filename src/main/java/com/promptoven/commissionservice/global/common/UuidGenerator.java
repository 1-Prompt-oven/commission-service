package com.promptoven.commissionservice.global.common;

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class UuidGenerator {

    public static String generatePurchaseUuid() {
        return "CM-" + UUID.randomUUID().toString();
    }
}