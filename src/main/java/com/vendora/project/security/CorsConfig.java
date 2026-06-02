package com.vendora.project.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    // Set FRONTEND_URL env var on Railway to your Vercel deployment URL,
    // e.g. https://your-app.vercel.app — falls back to localhost for local dev.
    @Value("${FRONTEND_URL:http://localhost:5173}")
    private String frontendUrl;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // React app origin — driven by FRONTEND_URL environment variable
        config.setAllowedOrigins(List.of(frontendUrl));

        // Allowed HTTP methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allowed headers
        config.setAllowedHeaders(List.of("*"));

        // Allow sending JWT in headers
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        // Apply this CORS config to all endpoints
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
