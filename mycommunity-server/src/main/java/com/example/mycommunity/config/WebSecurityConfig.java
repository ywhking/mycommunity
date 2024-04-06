package com.example.mycommunity.config;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final JwtAuthProperties properties;

    //@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	//String jwkSetUri = properties.getAuthHost() + properties.getAuthPort() + properties.getAuthClient();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests((authorize) -> {
                authorize.anyRequest().authenticated();
            })
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
            .build();
    }

    @Bean
	JwtDecoder jwtDecoder() {
        // https://${AUTH_HOST}:${AUTH_PORT}/realms/${AUCH_CLIENT}/protocol/openid-connect/certs
        String jwkSetUri = "https://" + properties.getAuthHost() + ":" + properties.getAuthPort() + "/realms/"  + properties.getAuthRealm() + "/protocol/openid-connect/certs";
		NimbusJwtDecoder jwtDecoder  = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
		jwtDecoder.setJwtValidator(JwtValidators.createDefault());
		return jwtDecoder;
	}

    public static final String MOVIES_MANAGER = "MOVIES_MANAGER";
    public static final String MOVIES_USER = "MOVIES_USER";
}