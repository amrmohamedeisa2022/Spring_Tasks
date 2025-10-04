package vehiclesSystem.controller;

import vehiclesSystem.config.AppConfig;
import vehiclesSystem.models.Plane;
import vehiclesSystem.service.PlaneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlaneController {

    public static void main(String[] args)
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Plane plane=context.getBean("plane", Plane.class);
        //plane.setId(15);
        plane.setModel("ford");
        plane.setName("mxz");

        PlaneService planeService=(PlaneService) context.getBean("planeService");
        planeService.save(plane);
        System.out.println("Car saved with ID: " + plane.getId());
    }
}
