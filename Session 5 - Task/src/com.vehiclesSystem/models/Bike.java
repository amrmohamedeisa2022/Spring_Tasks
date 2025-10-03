package com.vehiclesSystem.models;

import com.vehiclesSystem.config.DataBaseConfig;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bike implements Vehicle {

   @Autowired
    private DataBaseConfig dataBaseConfig;

    private int id;
    private String brand;
    private Type.VehicleType type;
    private String name;


    @Override
    public String getModel() {
        return "";
    }

    @Override
    public void setModel(String model) {

    }
}