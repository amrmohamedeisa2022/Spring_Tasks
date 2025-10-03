package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.service.BikeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BikeController {

    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
       Bike bike=context.getBean("bike", Bike.class);
        bike.setId(15);
        bike.setModel("BMW");
        bike.setName("amr");

        BikeService bikeService=(BikeService) context.getBean("bikeService");
        bikeService.save(bike);
        System.out.println("Car saved with ID: " + bike.getId());

    }
}
