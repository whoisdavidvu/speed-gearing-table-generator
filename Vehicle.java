import java.util.Scanner;
import java.io.IOException;

public class Vehicle
{
    public static Scanner sc = new Scanner (System.in);
    public static double differential;
    public static double gearing;

    public Vehicle(double diff, double gear)
    {
        //super(tirewidth, tireaspectratio, wheeldiameter);
        differential = diff;
        gearing = gear;
    }

    // Sets variables for this vehicle's gearing
    public static void setGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differential = sc.nextDouble();

        System.out.print("Enter transmission gearing: ");
        gearing = sc.nextDouble();
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Speed: " + getSpeed() + " km/h");
    }
}