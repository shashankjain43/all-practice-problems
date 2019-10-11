package com.practice.hackerrank.string;

import java.util.Scanner;
import java.io.*;


abstract class Car {
    protected boolean isSedan;
    protected String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public boolean getIsSedan() {
        return this.isSedan;
    }

    public String getSeats() {
        return this.seats;
    }

    abstract public String getMileage();

    public void printCar(String name) {
        System.out.println(
                "A " + name + " is " + (this.getIsSedan() ? "" : "not ")
                        + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
                        + this.getMileage() + ".");
    }
}

// Write your code here.

/**
 *   WagonR class
 **/
 class WagonR extends Car{

     int mileage;

    /*public WagonR(boolean isSedan, String seats) {
        super(isSedan, seats);
    }*/

    public WagonR(int mileage) {
        super(false, "4");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage+" kmpl";
    }
}

/**
 *   HondaCity class
 **/
class HondaCity extends Car{

    int mileage;
    public HondaCity(boolean isSedan, String seats) {
        super(isSedan, seats);
    }
    public HondaCity(int mileage) {
        this(true, "4");
        this.mileage = mileage;
    }


    @Override
    public String getMileage() {
        return mileage+" kmpl";
    }


}

/**
 *   InnovaCrysta class
 **/
class InnovaCrysta extends Car{
    int mileage;

    public InnovaCrysta(boolean isSedan, String seats) {
        super(isSedan, seats);
    }
    public InnovaCrysta(int mileage) {
        this(false, "6");
        this.mileage = mileage;
    }


    @Override
    public String getMileage() {
        return mileage+" kmpl";
    }


}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carType = Integer.parseInt(bufferedReader.readLine().trim());
        int carMileage = Integer.parseInt(bufferedReader.readLine().trim());

        if (carType == 0){
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
        }

        if(carType == 1){
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
        }

        if(carType == 2){
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
        }
    }
}