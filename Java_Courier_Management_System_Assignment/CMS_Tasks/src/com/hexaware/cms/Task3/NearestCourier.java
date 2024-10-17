package com.hexaware.cms.Task3;

/*
 * 8. Implement a method to find the nearest available courier for a new order using an array of couriers.

 */

import java.util.ArrayList;

public class NearestCourier {
    static class Courier {
        String name;
        double distance;

        Courier(String name, double distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        ArrayList<Courier> couriers = new ArrayList<>();
        couriers.add(new Courier("Courier A", 5.0));
        couriers.add(new Courier("Courier B", 3.0));
        couriers.add(new Courier("Courier C", 7.0));

        Courier nearest = couriers.get(0);
        for (Courier courier : couriers) {
            if (courier.distance < nearest.distance) {
                nearest = courier;
            }
        }

        System.out.println("Nearest available courier is: " + nearest.name);
    }
}

