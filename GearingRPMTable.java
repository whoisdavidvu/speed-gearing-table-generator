import java.util.Scanner;
import java.io.IOException;

public class GearingRPMTable
{
    // Calculates the wheel diameter in mm based on the tire width (in mm), aspect ratio and rim diameter (in inches).
    public static double getWheelDiameter()
    {
        // Method to extract tire size from one-line console input
        System.out.println("Enter tire size (Example: 195 55 16 for 195/55R16): ");
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int aspectratio = sc.nextInt();
        int rimdiameter = sc.nextInt();
        sc.close();

        // Calculates the wheel diameter based on data of console input.
        double wheeldiameter = (width * aspectratio / 100 * 2) + (rimdiameter * 25.4);
        return wheeldiameter;
    }

    public static void main (String[] args) throws IOException
    {
        System.out.println(getWheelDiameter() + " mm");
    }
}