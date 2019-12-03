package com.example.demo.service1.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RefreshScope
@Component
@NoArgsConstructor
@Setter
@Getter
public class MessageBeanConfiguration {

    @Value("${greetings.user:Hello default}")
    private String message;
    
}