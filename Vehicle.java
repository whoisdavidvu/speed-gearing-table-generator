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

    /*
    // Calculates the vehicle speed based on RPM, differential gearing, transmission gearing and wheel diameter.
    public static String getSpeed()
    {
        setGearing();
        System.out.print("Enter desired target rpm: ");
        int rpm = sc.nextInt();

        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double speed = (rpm * 60 * Math.PI * Wheel.getDiameter() * 0.000001) / (gearing * differential);
        return String.format("%.2f", speed);
    }*/

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Speed: " + getSpeed() + " km/h");
    }
}