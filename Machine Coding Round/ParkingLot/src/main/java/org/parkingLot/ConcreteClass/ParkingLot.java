package org.parkingLot.ConcreteClass;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingLot {
    @NonNull
    String parkingLotId;
    @NonNull
    List<ParkingFloor> parkingFloors;

    List<Ticket> tickets = new ArrayList<>();

}
