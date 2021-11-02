import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Vehicle
{
    public static Scanner sc = new Scanner (System.in);
    public static double differential;
    public static double singlegear;
    public static int revlimiter;
    public static int rpmintervals;
    public static int gearcount;
    public static ArrayList<Double> gearing = new ArrayList<>();

    // For later use
    /* public Vehicle(double differential_, double singlegear_, int revlimiter_, int gearcount_, double[] gearing_)
    {
        //super(tirewidth, tireaspectratio, wheeldiameter);
        differential = differential_;
        singlegear = singlegear_;
        revlimiter = revlimiter_;
        gearcount = gearcount_;
        gearing = gearing_;

    } */

    // Sets variables for a single gear of this vehicle
    public static void setSingleGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differential = sc.nextDouble();

        System.out.print("Enter transmission gearing: ");
        singlegear = sc.nextDouble();
    }

    // Method to set a car's differential and transmission gearing
    public static void setGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differential = sc.nextDouble();

        System.out.print("Enter number of gears: ");
        gearcount = sc.nextInt();

        for (int gearpos = 0; gearpos < gearcount; gearpos++) 
        {
            System.out.print("Enter gearing of gear " + (gearpos+1) + ": ");
            gearing.add(sc.nextDouble());
        }
    }

    // Sets rev limiter to display in table and rpm jumps
    public static void setRPMs()
    {
        System.out.print("Enter the engine redline rpm: ");
        revlimiter = sc.nextInt();

        System.out.print("Enter the rpm intervals to display on table: ");
        rpmintervals = sc.nextInt();
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Speed: " + getSpeed() + " km/h");
        //setGearing();
    }
}