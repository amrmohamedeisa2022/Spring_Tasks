package main.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("main")
@PropertySource("classpath:app.properties")
public class AppConfig {



}
