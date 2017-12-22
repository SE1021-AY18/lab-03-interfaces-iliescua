/*
*Course: SE1021
*Winter 2017
*Lab 3
*Name: Andrew Iliescu
*Project: Nut Class
*Created: 12/13/2017
*/
import java.text.DecimalFormat;

public class Nut implements Part {
    private double diameterInches;//stores the value of the diameter in inches
    final static double LBS_MULTIPLIER = 0.01;//constant for the weight multiplier
    final static double USD_MULTIPLIER = 0.5;//constant for the cost multiplier
    private String name = " inch nut";//stores the name
    DecimalFormat weightFormat = new DecimalFormat("##0.###");//formats the weight result
    DecimalFormat costFormat = new DecimalFormat("0.00");//formats the cost result
    final int squared = 2;//constant used in weight equation

    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
    }

    /**
     * calculates and returns the value of cost
     * @return the value of cost
     */
    public double getCost() {
        return USD_MULTIPLIER * diameterInches;
    }

    /**
     * returns the name to be displayed
     * @return name so it can be displayed
     */
    public String getName() {
        return diameterInches + name;
    }

    /**
     * calculates the weight and returns it
     * @return the weight value
     */
    public double getWeight() {
        return LBS_MULTIPLIER * (Math.pow(diameterInches, squared));
    }

    /**
     * used to print out the weight, cost, name, and the diameter of nuts
     */
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Cost: $" + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs\n");
    }
}