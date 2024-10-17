package com.hexaware.cms.Task1;

import java.util.ArrayList;
import java.util.List;

/*
 * 4. Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based
on predefined criteria (e.g., proximity, load capacity) using loops.
 */

public class CourierAssignment {
    static class Courier {
        String name;
        int loadCapacity;

        Courier(String name, int loadCapacity) {
            this.name = name;
            this.loadCapacity = loadCapacity;
        }
    }

    public static void main(String[] args) {
        List<Courier> couriers = new ArrayList<>();
        couriers.add(new Courier("Courier A", 10));
        couriers.add(new Courier("Courier B", 20));
        couriers.add(new Courier("Courier C", 15));

        int shipmentWeight = 12;

        for (Courier courier : couriers) {
            if (courier.loadCapacity >= shipmentWeight) {
                System.out.println("Assigned " + courier.name + " to the shipment.");
                break;
            }
        }
    }
}
