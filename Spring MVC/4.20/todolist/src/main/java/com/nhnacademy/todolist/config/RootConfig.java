package com.nhnacademy.todolist.config;


import com.nhnacademy.todolist.repository.MemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.todolist"})
public class RootConfig {


}
