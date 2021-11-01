import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.text.DecimalFormat;

public class GearingRPMTable
{
    public static Scanner sc = new Scanner (System.in);

    // Calculates the wheel diameter in mm based on the tire width (in mm), aspect ratio and rim diameter (in inches).
    public static double getWheelDiameter()
    {
        // Method to extract tire size from one-line console input
        System.out.print("Enter tire size (Example: 195 55 16 for 195/55R16): ");
        //Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int aspectratio = sc.nextInt();
        int rimdiameter = sc.nextInt();
        

        // Calculates the wheel diameter based on data of console input.
        double wheeldiameter = (width * aspectratio / 100 * 2) + (rimdiameter * 25.4);
        return wheeldiameter;
    }

    // Calculates the vehicle speed based on RPM, differential gearing, transmission gearing and wheel diameter.
    public static String getSpeed()
    {
        double wheeldiameter = getWheelDiameter();
        
        System.out.print("Enter differential gear ratio: ");
        //Scanner sc = new Scanner(System.in);
        double differential = sc.nextDouble();

        System.out.print("Enter transmission gearing: ");
        double transgearing = sc.nextDouble();

        System.out.print("Enter desired target rpm: ");
        int rpm = sc.nextInt();

        sc.close();

        /*
        System.out.println("Enter number of transmission gears: ");
        int gearcount = sc.nextInt();
        */

        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double speed = (rpm * 60 * Math.PI * wheeldiameter * 0.000001) / (transgearing * differential);
        return String.format("%.2f", speed);
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Total diameter of the wheel is: " + getWheelDiameter() + " mm");
        System.out.println("Speed: " + getSpeed() + " km/h");
    }
}