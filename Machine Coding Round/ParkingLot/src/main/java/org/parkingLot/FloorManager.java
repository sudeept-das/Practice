package org.parkingLot;

import org.parkingLot.ConcreteClass.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.parkingLot.ConcreteClass.VehicleType.BIKE;
import static org.parkingLot.ConcreteClass.VehicleType.CAR;

public class FloorManager {
    List<ParkingSlot> getParkingSlot(ParkingFloor floor, final VehicleType vehicleType)
    {
        List<ParkingSlot> parkingSlots = floor.getParkingSlots()
                .get(vehicleType).stream()
                .filter(slot -> slot.getIsAvailable()==Boolean.TRUE).toList();
        return parkingSlots;
    }

    public Ticket bookSlot(ParkingSlot slotFound, ParkingFloor slotFloor, Vehicle vehicle, ParkingLot parkingLot) {
        slotFound.setIsAvailable(false);
        Ticket ticket = new Ticket(parkingLot.getParkingLotId()+"_"+slotFloor.getFloorNumber()+"_"+slotFound.getSlotNumber(), vehicle, slotFound);
        System.out.println("Parked vehicle. Ticket ID: "+ticket.getTicketId());
        parkingLot.getTickets().add(ticket);
        return ticket;
    }


    public Map<VehicleType,List<ParkingSlot>> createFloorSlots(Integer parkingSlots) {
        Map<VehicleType,List<ParkingSlot>> parkingSlotList = new HashMap<>();
        for(int i=1; i<=parkingSlots; i++)
        {
            if(i==1)
                parkingSlotList.put(VehicleType.TRUCK,List.of(new ParkingSlot(VehicleType.TRUCK, i)));
            else if(i<4) {
                if(!parkingSlotList.containsKey(BIKE))
                    parkingSlotList.put(BIKE, new ArrayList<>());
                List<ParkingSlot> slots = parkingSlotList.get(BIKE);
                slots.add(new ParkingSlot(BIKE, i));
                parkingSlotList.put(BIKE, slots);
            }
            else
            {
                if(!parkingSlotList.containsKey(CAR))
                    parkingSlotList.put(CAR, new ArrayList<>());
                List<ParkingSlot> slots = parkingSlotList.get(CAR);
                slots.add(new ParkingSlot(CAR, i));
                parkingSlotList.put(CAR, slots);
            }
        }
        return parkingSlotList;
    }
}
