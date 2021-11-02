import java.util.Scanner;
import java.io.IOException;

public class Wheel
{
    public static Scanner sc = new Scanner (System.in);
    public static int tirewidth;
    public static int tireaspectratio;
    public static int wheeldiameter;

    /* public Wheel(int tirewidth_, int tireaspectratio_, int wheeldiameter_)
    {
        tirewidth = tirewidth_;
        tireaspectratio = tireaspectratio_;
        wheeldiameter = wheeldiameter_;
    } */

    public static void setWheel()
    {
        // Method to extract tire size from one-line console input
        System.out.print("Enter tire size (Example: 195 55 16 for 195/55R16): ");
        tirewidth = sc.nextInt();
        tireaspectratio = sc.nextInt();
        wheeldiameter = sc.nextInt();
    }


    // Calculates the wheel diameter in mm based on the tire width (in mm), aspect ratio and rim diameter (in inches).
    public static double getDiameter()
    {
        setWheel();
        double diameter = (tirewidth * tireaspectratio / 100 * 2) + (wheeldiameter * 25.4);
        return diameter;
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println(getDiameter() + " mm");
    }
}