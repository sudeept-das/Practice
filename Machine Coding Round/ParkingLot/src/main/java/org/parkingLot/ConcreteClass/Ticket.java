package org.parkingLot.ConcreteClass;

import lombok.Data;
import lombok.NonNull;

@Data
public class Ticket {
    @NonNull
    String ticketId;
    @NonNull
    Vehicle vehicle;
    @NonNull
    ParkingSlot parkingSlot;
}
