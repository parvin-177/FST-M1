package activities;

import activities.Car;

public class Activity1 {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = 2023;
        toyota.color = "White";
        toyota.transmission = "Auto";

        //Using Car class method
        toyota.displayCharacteristics();
        toyota.accelarate();
        toyota.brake();
    }

}