package com.leandersonandre.agenda.core.config;

import com.leandersonandre.agenda.core.entity.ColaboradorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ColaboradorConverter colaboradorConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(colaboradorConverter);
    }
}
