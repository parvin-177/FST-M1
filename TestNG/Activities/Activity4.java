package activities;

import org.testng.annotations.Test;

public class Activity4 {
    @Test(groups = { "Car" })
    public void Car1() {
        System.out.println("Batch Car - Test car 1");
    }

    @Test (groups = { "Car" })
    public void Car2() {
        System.out.println("Batch Car - Test car 2");
    }
    @Test(groups = { "Car" })
    public void Car11() {
        System.out.println("Batch Car - Test car 1");
    }

    @Test (groups = { "Car" })
    public void Car12() {
        System.out.println("Batch Car - Test car 2");
    }
}
