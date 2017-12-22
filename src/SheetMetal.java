/*
*Course: SE1021
*Winter 2017
*Lab 3
*Name: Andrew Iliescu
*Project: SheetMetal Class
*Created: 12/13/2017
*/
import java.text.DecimalFormat;

public class SheetMetal implements Part {
    final static double LBS_MULTIPLIER = 0.1;//constant for the weight multiplier
    final static double USD_MULTIPLIER = 0.5;//constant for the cost multiplier
    private double lengthInches;//stores the value of the length in inches
    private double thicknessInches;//stores the value of the thickness in inches
    private double widthInches;//stores the value of the width in inches
    private String name = " sheet";//stores the name
    DecimalFormat weightFormat = new DecimalFormat("##0.###");//formats the weight result
    DecimalFormat costFormat = new DecimalFormat("0.00");//formats the cost result

    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }

    /**
     * calculates and returns the value of cost
     * @return the value of cost
     */
    public double getCost() {
        return USD_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    /**
     * returns the name to be displayed
     * @return name so it can be displayed
     */
    public String getName() {
        return lengthInches + "x" + widthInches + "x" + thicknessInches + name;
    }

    /**
     * calculates the weight and returns it
     * @return the weight value
     */
    public double getWeight() {
        return LBS_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    /**
     * used to print out the weight, cost, name,
     * length, width and the thickness of sheet metal
     */
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Width: " + widthInches + " inches");
        System.out.println("Thickness " + thicknessInches + " inches");
        System.out.println("Cost: $" + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()) + " lbs\n");
    }
}