package edu.haramaya.cosc3053.day03;

public class Bicycle {

     int cadence = 0;
    int speed = 0;
    int gear = 1;

        void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedup(int increment) {
         speed += increment;
    }

    void printStates() {
    System.out.println("Cadence: " + cadence);
    System.out.println("Speed: " + speed);
    System.out.println("Gear: " + gear);
}
    void main(String[] args){


        Bicycle bike1 = new Bicycle();
        bike1.changeCadence(50);
        bike1.speedup(20);
        bike1.changeGear(2);
        bike1.printStates();

        Bicycle bike2 = new Bicycle();
        bike2.changeCadence(50);
        bike2.speedup(10);
        bike2.changeGear(5);
        bike2.printStates();


    }

}
