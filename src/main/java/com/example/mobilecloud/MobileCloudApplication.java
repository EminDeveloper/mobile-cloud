package com.example.mobilecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;


//This annotation tells Spring that this class contains configuration
//information
//for the application.
@Configuration
@SpringBootApplication

public class MobileCloudApplication {

    private static final int MAX_REQUEST_SIZE_IN_MB = 150;


    public static void main(String[] args) {
        SpringApplication.run(MobileCloudApplication.class, args);
    }


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        // Setup the application container to be accept multipart requests
        final MultipartConfigFactory factory = new MultipartConfigFactory();
        // Place upper bounds on the size of the requests to ensure that
        // clients don't abuse the web container by sending huge requests
        factory.setMaxFileSize(DataSize.ofMegabytes(MAX_REQUEST_SIZE_IN_MB));
        factory.setMaxRequestSize(DataSize.ofMegabytes(MAX_REQUEST_SIZE_IN_MB));

        // Return the configuration to setup multipart in the container
        return factory.createMultipartConfig();
    }
}
