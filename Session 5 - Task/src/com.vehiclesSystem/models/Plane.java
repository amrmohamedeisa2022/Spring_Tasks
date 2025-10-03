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
public class Plane implements Vehicle {

    private DataBaseConfig dataBaseConfig;
    private int id;
    private String name;
    private String model;
    private Type.VehicleType type;

    @Autowired

    public void setDataBaseConfig(DataBaseConfig dataBaseConfig)
    {
        this.dataBaseConfig=dataBaseConfig;
    }



}