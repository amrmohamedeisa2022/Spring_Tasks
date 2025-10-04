package vehiclesSystem.models;

import vehiclesSystem.config.DataBaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike extends Vehicle {

   @Autowired
    private DataBaseConfig dataBaseConfig;

}