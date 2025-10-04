package vehiclesSystem.models;

import vehiclesSystem.config.DataBaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Plane extends Vehicle {

    private DataBaseConfig dataBaseConfig;


    @Autowired
    public void setDataBaseConfig(DataBaseConfig dataBaseConfig)
    {
        this.dataBaseConfig=dataBaseConfig;
    }


}