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
public class Car  {

    private DataBaseConfig dataBaseConfig;
    private int id;
    private Type.VehicleType type;
    private String model;
    private String name;



    @Autowired
    public Car(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig = dataBaseConfig;
    }



}