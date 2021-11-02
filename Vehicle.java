import java.util.Scanner;
import java.io.IOException;

public class Vehicle
{
    public static Scanner sc = new Scanner (System.in);
    public static double differential;
    public static double gearing;
    public static int revlimiter;
    public static int rpmintervals;

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

    }

    // Sets highest rpm to display in table and rpm jumps
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
    }
}