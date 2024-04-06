package com.example.mycommunity.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "jwt.auth")
public class JwtAuthProperties {

    @NotBlank
    private String authHost;
    private Integer authPort;
    private String authRealm;
    private String originUrl;

}
