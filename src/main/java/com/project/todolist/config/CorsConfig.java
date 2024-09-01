package com.project.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Angular uygulamanızın çalıştığı adres
                .allowedMethods("*") // Tüm HTTP metodlarına izin ver
                .maxAge(3600L) // CORS sonuçlarının tarayıcıda cachelenme süresi
                .allowedHeaders("*") // Tüm header'lara izin ver
                .exposedHeaders("Authorization") // Authorization header'ını client tarafında erişilebilir hale getir
                .allowCredentials(true); // Cookies ve Authorization gibi credential bilgilerini dahil et
    }
}
