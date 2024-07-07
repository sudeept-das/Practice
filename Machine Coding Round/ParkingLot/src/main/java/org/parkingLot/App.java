package org.parkingLot;

import org.parkingLot.ConcreteClass.Vehicle;
import org.parkingLot.ConcreteClass.VehicleType;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bi = new BufferedReader(
                new InputStreamReader(System.in));
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        int flag =1;
        while(flag==1)
        {
            try {
                String[] str;
                str = bi.readLine().split(" ");
                if (str.length == 1 && str[0].equalsIgnoreCase("Exit"))
                    break;
                if (str[0].equalsIgnoreCase("create_parking_lot")) {
                    String parkingLotId = str[1];
                    Integer parkingFloorsCount = Integer.parseInt(str[2]), parkingSlotCount = Integer.parseInt(str[3]);
                    parkingLotManager.createParkingLot(parkingLotId, parkingFloorsCount, parkingSlotCount);
                } else if (str[0].equalsIgnoreCase("display")) {
                    if (str[1].equalsIgnoreCase("free_count")) {
                        parkingLotManager.displayFreeCount(VehicleType.valueOf(str[2]));
                    } else if (str[1].equalsIgnoreCase("free_slots")) {
                        parkingLotManager.displayFreeSlots(VehicleType.valueOf(str[2]));
                    } else if (str[1].equalsIgnoreCase("occupied_slots")) {
                        parkingLotManager.displayOccupiedSlots(VehicleType.valueOf(str[2]));
                    }
                } else if (str[0].equalsIgnoreCase("park_vehicle")) {
                    Vehicle vehicle = new Vehicle(str[2], VehicleType.valueOf(str[1]), str[3]);
                    parkingLotManager.parkVehicle(vehicle);
                } else if (str[0].equalsIgnoreCase("unpark_vehicle")) {
                    parkingLotManager.unPark(str[1]);
                }
            } catch(Exception ex)
            {
                System.out.println("System crashed due to: "+ex.getMessage());
            }
        }
    }
}
