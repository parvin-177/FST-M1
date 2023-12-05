package activities;

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        //There is a plane with max 10 passengers
        Plane plane = new Plane(10);
        //Add passengers on the list
        plane.passengerOnBoard("Amit");
        plane.passengerOnBoard("Sujit");
        plane.passengerOnBoard("Vedika");
        plane.passengerOnBoard("Praveen");
        plane.passengerOnBoard("Vishal");
        //Plane takes off
        System.out.println("Plane took off at: " + plane.planeTakeOff());
        //Print list of people on board
        System.out.println("People on the plane: " + plane.getPassengers());
        //Flying.....
        Thread.sleep(1000);
        //Plane has landed
        plane.planLand();
        //Plane lands
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}