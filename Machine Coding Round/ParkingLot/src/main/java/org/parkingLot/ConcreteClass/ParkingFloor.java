package org.parkingLot.ConcreteClass;

import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@Data
public class ParkingFloor {
    @NonNull
    int FloorNumber;
    @NonNull
    Map<VehicleType, List<ParkingSlot>> parkingSlots;
    @NonNull
    Integer numberOfSlots;

}
