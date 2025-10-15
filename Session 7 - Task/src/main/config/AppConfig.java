package main.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("main")
@PropertySource("classpath:main/webapp/resources/application.properties")
public class AppConfig {



}
