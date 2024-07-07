package org.parkingLot.ConcreteClass;

import lombok.Data;
import lombok.NonNull;

@Data
public class ParkingSlot {
    @NonNull
    VehicleType vehicleType;
    @NonNull
    Integer SlotNumber;
    @NonNull
    Boolean isAvailable = true;
}
