import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;

public class Functions
{
    public static Scanner sc = new Scanner (System.in);

    // Calculates the vehicle speed based on RPM, differential gearing, transmission gearing and wheel diameter.
    public static String getSingleSpeed()
    {
        Vehicle.setSingleGearing();
        System.out.print("Enter desired target rpm: ");
        int rpm = sc.nextInt();

        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double speed = (rpm * 60 * Math.PI * Wheel.getDiameter() * 0.000001) / (Vehicle.singlegear * Vehicle.differential);
        return String.format("%.2f", speed);
    }

    public static String getSpeed(int rpm, double gearratio, double wheeldiameter)
    {
        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double speed = (rpm * 60 * Math.PI * wheeldiameter * 0.000001) / (gearratio * Vehicle.differential);
        return String.format("%.2f", speed);
    }

    // Calculates speeds for a range of rpms and displays it as a table
    public static void getTable()
    {
        Vehicle.setGearing();
        Vehicle.setRPMs();

        // Determines the number of rows needed for the table
        int rpmsteps;
        boolean hasLastRPMStep = false;
        if (Vehicle.revlimiter % Vehicle.rpmintervals == 0)
        {
            rpmsteps = Vehicle.revlimiter / Vehicle.rpmintervals;
        }
        else 
        {
            rpmsteps = (Vehicle.revlimiter / Vehicle.rpmintervals) + 1;
            hasLastRPMStep = true;
        }

        final Object[][] table = new String[rpmsteps+1][Vehicle.gearcount+1];

        // Initialize first row with information
        table[0][0] = "rpm";
        for (int i = 1; i < Vehicle.gearcount+1; i++)
        {
            table[0][i] = "Gear " + i + ": " + Vehicle.gearing.get(i-1); 
        }

        // Initialize first column with rpms and do speed calculations
        double localwheeldiameter = Wheel.getDiameter();
        for (int i = 1; i <= rpmsteps; i++)
        {
            int rpms = (1000+((i-1)*Vehicle.rpmintervals));
            if (hasLastRPMStep && i == rpmsteps)
            {
                rpms = Vehicle.revlimiter;
            }
            table[i][0] = Integer.toString(rpms);
            for (int j = 1; j <= Vehicle.gearcount; j++)
            {
                table[i][j] = getSpeed(rpms, Vehicle.gearing.get(j-1), localwheeldiameter) + " km/h";
            }
        }

        // For printing table
        for (final Object[] row : table) {
            System.out.format("%-15s%15s%15s%15s%15s%15s%15s%n", row);
        }
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Speed: " + getSingleSpeed() + " km/h");
        //Vehicle.setGearing();
        //System.out.println(Vehicle.gearing.get(0));
        getTable();
    }
}