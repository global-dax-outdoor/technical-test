package com.global.dax.server.config;

import com.global.dax.core.ComicBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ComicBookRepository comicBookRepository() {

        return new ComicBookRepository();
    }
}
