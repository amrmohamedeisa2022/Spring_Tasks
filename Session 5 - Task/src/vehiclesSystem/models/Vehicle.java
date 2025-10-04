package vehiclesSystem.models;

import lombok.*;
import org.springframework.context.annotation.Scope;


@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public abstract class Vehicle {

    int id;
    Type.VehicleType type;
    String model;
    String name;



}
