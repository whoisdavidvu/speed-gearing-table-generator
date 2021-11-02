import java.util.Scanner;
import java.io.IOException;

public class Vehicle
{
    public static Scanner sc = new Scanner (System.in);
    public static double differential;
    public static double singlegearing;
    public static int revlimiter;
    public static int rpmintervals;
    public static int gearcount;
    public static double[] gearing;

    public Vehicle(double diff, double gear, int redline, int gears)
    {
        //super(tirewidth, tireaspectratio, wheeldiameter);
        differential = diff;
        singlegearing = gear;
        revlimiter = redline;
        gearcount = gears;
    }

    // Sets variables for a single gear of this vehicle
    public static void setSingleGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differential = sc.nextDouble();

        System.out.print("Enter transmission gearing: ");
        singlegearing = sc.nextDouble();
    }

    public static void setGearing()
    {
        System.out.print("Enter differential gear ratio: ");
        differential = sc.nextDouble();

        System.out.print("Enter number of gears: ");
        gearcount = sc.nextInt();

        double[] gearing = new double[gearcount];

        for (int gearpos = 0; gearpos < gearcount; gearpos++) 
        {
            System.out.print("Enter gearing of gear " + (gearpos+1) + ": ");
            gearing[gearpos] = sc.nextDouble();
        }

        // for-loop to check result
        /* for (int gearpos = 0; gearpos < gearcount; gearpos++)
        {
            System.out.print(gearing[gearpos] + " ");
        } */
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
        setGearing();
    }
}