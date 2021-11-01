import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;

public class Speed
{
    public static Scanner sc = new Scanner (System.in);

    // Calculates the vehicle speed based on RPM, differential gearing, transmission gearing and wheel diameter.
    public static String getSpeed()
    {
        Vehicle.setGearing();
        System.out.print("Enter desired target rpm: ");
        int rpm = sc.nextInt();

        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double speed = (rpm * 60 * Math.PI * Wheel.getDiameter() * 0.000001) / (Vehicle.gearing * Vehicle.differential);
        return String.format("%.2f", speed);
    }

    public static void main (String[] args) throws IOException
    {
        System.out.println("Speed: " + getSpeed() + " km/h");
    }
}