import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

public class CreateTable
{
    public static Scanner sc = new Scanner (System.in);

    // Calculates the vehicle speed based on RPM, differential gearing, transmission gearing and wheel diameter.
    public static String getSingleSpeed()
    {
        Vehicle.setSingleGearing();
        System.out.print("Enter desired target rpm: ");
        int rpm = sc.nextInt();

        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double speed = (rpm * 60 * Math.PI * Wheel.getWheelDiameter() * 0.000001) / (Vehicle.singlegear * Vehicle.differentialGearing);
        return String.format("%.2f", speed);
    }

    public static String getMetricSpeed(int rpm, double gearratio, double wheeldiameter)
    {
        // rpm * 60 (for revolutions per hour) * pi * diameter * 0.000001km (mm to km) / (gear ratio * axle ratio)
        double metricSpeed = (rpm * 60 * Math.PI * wheeldiameter * 0.000001) / (gearratio * Vehicle.differentialGearing);
        return String.format("%.2f", metricSpeed);
    }

    // Calculates speeds for a range of rpms and displays it as a table
    public static void getSpeedRPMTable()
    {
        Vehicle.setGearing();
        Vehicle.setRPMs();

        // Determines the number of rows needed for the table
        int totalRPMSteps;
        boolean hasLastRPMStep = false;

        // Number of rpm steps for the table (+1 because 1000rpm has to be included)
        if (Vehicle.revlimiter % Vehicle.rpmintervals == 0)
        {
            totalRPMSteps = (Vehicle.revlimiter-1000) / Vehicle.rpmintervals + 1;
        }
        else 
        {
            totalRPMSteps = ((Vehicle.revlimiter-1000) / Vehicle.rpmintervals) + 2;
            hasLastRPMStep = true;
        }

        final String[][] table = new String[totalRPMSteps+1][Vehicle.maxGearCount+1];

        // Initialize first row with information
        table[0][0] = "rpm";
        for (int i = 1; i < Vehicle.maxGearCount+1; i++)
        {
            table[0][i] = "Gear " + i + ": " + Vehicle.gearingList.get(i-1); 
        }

        // Initialize first column with rpms and do speed calculations
        double localWheelDiameter = Wheel.getWheelDiameter();
        for (int currentRPMStep = 1; currentRPMStep <= totalRPMSteps; currentRPMStep++)
        {
            int currentRPMs = (1000+((currentRPMStep-1)*Vehicle.rpmintervals));
            if (hasLastRPMStep && currentRPMStep == totalRPMSteps)
            {
                currentRPMs = Vehicle.revlimiter;
            }
            table[currentRPMStep][0] = Integer.toString(currentRPMs);
            for (int currentGear = 1; currentGear <= Vehicle.maxGearCount; currentGear++)
            {
                table[currentRPMStep][currentGear] = getMetricSpeed(currentRPMs, Vehicle.gearingList.get(currentGear-1), localWheelDiameter) + " km/h";
            }         
        }

        // For printing table
        String format = "%-15s" + "%15s".repeat(Vehicle.maxGearCount) + "%n";
        for (final Object[] row : table) {
            System.out.format(format, row);
        }

        // Saves data output into a .csv file
        System.out.print("Do you wish to save this data in a .csv file? (yes/no): ");
        String csvPrompt = sc.next();
        if (csvPrompt.contains("yes"))
        {
            System.out.print("Set filename: ");
            String path = sc.next();
            try 
            {
                FileWriter writer = new FileWriter(path);
                for (String[] data : table) 
                {
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < data.length; i++) 
                    {
                        line.append("\"");
                        line.append(data[i].replaceAll("\"","\"\""));
                        line.append("\"");
                        if (i != data.length - 1) 
                        {
                            line.append(',');
                        }
                    }
                    line.append("\n");
                    writer.write(line.toString());
                }
                writer.close();
            }
            catch (IOException ex) 
            {
                System.out.println(ex.toString());
                System.out.println("Invalid input!");
            }
        }
        else { System.exit(0); } 
    }

    public static void main (String[] args) throws IOException
    {
        //System.out.println("Speed: " + getSingleSpeed() + " km/h");
        //Vehicle.setGearing();
        //System.out.println(Vehicle.gearing.get(0));
        getSpeedRPMTable();
    }
}