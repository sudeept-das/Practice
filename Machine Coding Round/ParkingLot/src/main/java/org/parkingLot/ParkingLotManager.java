package org.parkingLot;

import org.parkingLot.ConcreteClass.*;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLotManager {

    ParkingLot parkingLot;
    FloorManager floorManager;

    ParkingLotManager(){
        floorManager = new FloorManager();
    }

    ParkingLot createParkingLot(String parkingLotId, Integer parkingFloorsCount, Integer parkingSlotCount){
        parkingLot = new ParkingLot(parkingLotId,new ArrayList<>());
        for(int i=0; i<parkingFloorsCount; i++)
            addFloorToParkingLot(parkingSlotCount);
        System.out.println("Created parking lot with "+ parkingFloorsCount +" floors and "+ parkingSlotCount +" slots per floor");
        return parkingLot;
    }

    ParkingLot addFloorToParkingLot(Integer parkingSlots)
    {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        ParkingFloor parkingFloor = new ParkingFloor(parkingFloors.size()+1,floorManager.createFloorSlots(parkingSlots), parkingSlots);
        parkingFloors.add(parkingFloor);
        Collections.sort(parkingFloors, new Comparator<ParkingFloor>() {
            @Override
            public int compare(ParkingFloor o1, ParkingFloor o2) {
                return Integer.compare(o1.getFloorNumber(), o2.getFloorNumber());
            }
        });
        parkingLot.setParkingFloors(parkingFloors);
        return parkingLot;
    }

    Ticket unPark(String ticketId){
        Optional<Ticket> filteredTicket = parkingLot.getTickets().stream().filter(ticket -> ticketId.equalsIgnoreCase(ticket.getTicketId())).findFirst();

        if(filteredTicket.isEmpty()) {
            System.out.println("Invalid Ticket");
            return null;
        }
        else {
            filteredTicket.get().getParkingSlot().setIsAvailable(true);
            System.out.println("Unparked vehicle with Registration Number: " + filteredTicket.get().getTicketId()
                    + "  and Color: " + filteredTicket.get().getVehicle().getColor());
            return filteredTicket.get();
        }
    }

    Ticket parkVehicle(Vehicle vehicle)
    {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        ParkingSlot slotFound = null;
        ParkingFloor slotFloor = null;
        for(ParkingFloor parkingFloor : parkingFloors)
        {
            List<ParkingSlot> availableSlot = floorManager.getParkingSlot(parkingFloor, vehicle.getVehicleType());
            if(availableSlot.size()>0) {
                slotFound = availableSlot.get(0);
                slotFloor = parkingFloor;
                break;
            }
        }
        if(slotFound==null) {
            System.out.println("Parking Lot Full");
            return null;
        }
        return floorManager.bookSlot(slotFound, slotFloor, vehicle, parkingLot);
    }

    void displayFreeCount(VehicleType vehicleType)
    {
        for(ParkingFloor floor: parkingLot.getParkingFloors())
        {
            Integer count = Math.toIntExact(floor.getParkingSlots().get(vehicleType).stream()
                    .filter(slot -> slot.getIsAvailable() && slot.getVehicleType().equals(vehicleType)).count());
            System.out.println("No. of free slots for "+vehicleType.toString()+" on Floor "+ floor.getFloorNumber()+ " : "+ count);
        }
    }

    void displayFreeSlots(VehicleType vehicleType)
    {
        for(ParkingFloor floor: parkingLot.getParkingFloors())
        {
            List<ParkingSlot> availableSlots = floor.getParkingSlots().get(vehicleType).stream()
                    .filter(slot -> slot.getIsAvailable() && slot.getVehicleType().equals(vehicleType)).toList();
            System.out.println("Free slots for "+vehicleType.toString()+" on Floor "+ floor.getFloorNumber()+ " : "
                    +availableSlots.stream().map(ParkingSlot::getSlotNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }

    void displayOccupiedSlots(VehicleType vehicleType)
    {
        for(ParkingFloor floor: parkingLot.getParkingFloors())
        {
            List<ParkingSlot> availableSlots = floor.getParkingSlots().get(vehicleType).stream()
                    .filter(slot -> !slot.getIsAvailable() && slot.getVehicleType().equals(vehicleType)).toList();
            System.out.println("Occupied slots for "+vehicleType.toString()+" on Floor "+ floor.getFloorNumber()+ " : "
                    +availableSlots.stream().map(ParkingSlot::getSlotNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
