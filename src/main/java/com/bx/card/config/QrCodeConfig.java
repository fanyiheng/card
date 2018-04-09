package com.bx.card.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "qr-code")
@Data
public class QrCodeConfig {
    private String qrCodeRepository;
    private String logoRepository;
}
