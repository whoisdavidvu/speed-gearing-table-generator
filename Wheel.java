import java.util.Scanner;
import java.io.IOException;

public class Wheel
{
    public static Scanner sc = new Scanner (System.in);
    public static int tirewidth;
    public static int tireaspectratio;
    public static int rimdiameter;

    /* public Wheel(int tirewidth_, int tireaspectratio_, int wheeldiameter_)
    {
        tirewidth = tirewidth_;
        tireaspectratio = tireaspectratio_;
        wheeldiameter = wheeldiameter_;
    } */

    // Method to set tire size
    public static void setTireSize()
    {
        System.out.print("Enter tire size (Example: 195 55 16 for 195/55R16): ");
        tirewidth = sc.nextInt();
        tireaspectratio = sc.nextInt();
        rimdiameter = sc.nextInt();
    }


    // Calculates the wheel diameter in mm based on the tire width (in mm), aspect ratio and rim diameter (in inches).
    public static double getWheelDiameter()
    {
        setTireSize();
        double wheeldiameter = (tirewidth * tireaspectratio / 100 * 2) + (rimdiameter * 25.4);
        return wheeldiameter;
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println(getDiameter() + " mm");
    }
}