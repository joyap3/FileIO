import java.io.Serializable;

/**
 * Created by joyapuryear on 7/11/17.
 */
//This is a POJO that uses the Serializable Interface.
    //The Serializable Interface is a tagging interface that notifies an application
    //that objects can be serialized (aka flattened)

public class Car implements Serializable {

    //using the transient keyword skips the vairable being saved
    //if you use this you will want to set the variable

    //transient int test;
    private String make = "";
    private int mileage = 0;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return make + " " + mileage;


    }
}
