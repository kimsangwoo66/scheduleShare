package com.example.recard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//업로드된 이미지 저장 및 불러오기를 하기 위한 외부경로 핸들러
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${resource.path}")
    private String resourcePath;

    @Value("${img.path}")
    private String img;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler(img).addResourceLocations(resourcePath);
    }
}
