package org.parkingLot.ConcreteClass;

import lombok.Data;
import lombok.NonNull;

@Data
public class Vehicle {
    @NonNull
    String vehicleId;
    @NonNull
    VehicleType vehicleType;
    @NonNull
    String color;
}
