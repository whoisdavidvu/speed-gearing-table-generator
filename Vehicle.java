import java.util.Scanner;
import java.io.IOException;

public class Vehicle
{
    public static Scanner sc = new Scanner (System.in);
    public static double differential;
    public static double gearing;
    public static double revlimiter;

    public Vehicle(double diff, double gear, int redline)
    {
        //super(tirewidth, tireaspectratio, wheeldiameter);
        differential = diff;
        gearing = gear;
        revlimiter = redline;
    }

    // Sets variables for this vehicle's gearing
    public static void setGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differential = sc.nextDouble();

        System.out.print("Enter transmission gearing: ");
        gearing = sc.nextDouble();

        System.out.print("Enter the engine redline rpm: ");
        revlimiter = sc.nextDouble();
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Speed: " + getSpeed() + " km/h");
    }
}