package vehiclesSystem.controller;

import vehiclesSystem.config.AppConfig;
import vehiclesSystem.models.Car;
import vehiclesSystem.models.Type;
import vehiclesSystem.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class CarController {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Car car=context.getBean("car", Car.class);
        car.setType(Type.VehicleType.Car);
       car.setModel("BMW");
       car.setName("amr");
       CarService carService=(CarService) context.getBean("carService");
        carService.save(car);
        System.out.println("Car saved with ID: " + car.getId());
context.close();
        carService.delete(17);

    }


}
