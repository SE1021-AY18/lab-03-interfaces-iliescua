/*
*Course: SE1021
*Winter 2017
*Lab 3
*Name: Andrew Iliescu
*Project: Bolt Class
*Created: 12/13/2017
*/
import java.text.DecimalFormat;

public class Bolt implements Part {
    private double diameterInches;//stores the value of the diameter in inches
    private double lengthInches;//stores the value of the length in inches
    final static double LBS_MULTIPLIER = 0.05;//constant for the weight multiplier
    final static double USD_MULTIPLIER = 1.00;//constant for the cost multiplier
    private String name = " bolt";//stores the name
    DecimalFormat weightFormat = new DecimalFormat("##0.###");//formats the weight result
    DecimalFormat costFormat = new DecimalFormat("0.00");//formats the cost result
    private final int squared = 2;//constant used in weight equation

    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    /**
     * calculates and returns the value of cost
     * @return the value of cost
     */
    public double getCost() {
        return USD_MULTIPLIER * lengthInches * diameterInches;
    }

    /**
     * returns the name to be displayed
     * @return name so it can be displayed
     */
    public String getName() {
        return diameterInches + "x" + lengthInches + name;
    }

    /**
     * calculates the weight and returns it
     * @return the weight value
     */
    public double getWeight() {
        return LBS_MULTIPLIER * (Math.pow(diameterInches, squared)) * lengthInches;
    }

    /**
     * used to print out the weight, cost, name, length, and the diameter of bolts
     */
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Cost: $" + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs\n");
    }
}