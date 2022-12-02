import java.util.ArrayList;
import java.util.Scanner;
public class Vehicle
{
    public static Scanner sc = new Scanner (System.in);
    public static double differentialGearing;
    public static double singlegear;
    public static int revlimiter;
    public static int rpmintervals;
    public static int maxGearCount;
    public static ArrayList<Double> gearingList = new ArrayList<>();

    // Sets variables for a single gear of this vehicle
    /* public static void setSingleGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differentialGearing = sc.nextDouble();

        System.out.print("Enter transmission gearing: ");
        singlegear = sc.nextDouble();
    } */

    // Method to set a car's differential and transmission gearing
    public static void setGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differentialGearing = sc.nextDouble();

        System.out.print("Enter number of gears: ");
        maxGearCount = sc.nextInt();

        for (int gearposition = 0; gearposition < maxGearCount; gearposition++) 
        {
            System.out.print("Enter gearing of gear " + (gearposition+1) + ": ");
            gearingList.add(sc.nextDouble());
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

}