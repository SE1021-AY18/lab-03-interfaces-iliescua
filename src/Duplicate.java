/*
*Course: SE1021
*Winter 2017
*Lab 3
*Name: Andrew Iliescu
*Project: Duplicate Class
*Created: 12/13/2017
*/
import java.text.DecimalFormat;

public class Duplicate implements Part {
    private DecimalFormat costFormat = new DecimalFormat("0.00");//formats the cost result
    private DecimalFormat weightFormat = new DecimalFormat("##0.###");//formats the weight result
    private Part identicalPart;//creates a part called identical part
    private int numDuplicates;//used to stores the number of duplicates
    final static double REDUCTION_FACTOR1 = 0.95;//constant used in cost calculation
    final static double REDUCTION_FACTOR2 = 0.9;//constant used in cost calculation
    final static int USD_THRESHOLD1 = 5;//constant used in cost calculation
    final static int USD_THRESHOLD2 = 10;//constant used in cost calculation

    public Duplicate(Part identicalPart, int numDuplicates) {
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

    /**
     * calculates and returns the value of cost
     * @return the value of cost
     */
    public double getCost() {
        if (numDuplicates < USD_THRESHOLD1) {
            return identicalPart.getCost() * numDuplicates;
        } else if (numDuplicates < USD_THRESHOLD2) {
            return identicalPart.getCost() * REDUCTION_FACTOR1 * numDuplicates;
        } else {
            return identicalPart.getCost() * REDUCTION_FACTOR2 * numDuplicates;
        }
    }

    /**
     * returns the name to be displayed
     * @return name so it can be displayed
     */
    public String getName() {
        return numDuplicates + " " + identicalPart.getName() + "s";
    }

    /**
     * calculates the weight and returns it
     * @return the weight value
     */
    public double getWeight() {
        return (identicalPart.getWeight() * numDuplicates);
    }

    /**
     * used to print out the name of the identical part as well as
     * the number of duplicates and the individual values for cost
     * and weight as well as the total cost and weight of the object
     */
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Duplicate part: " + identicalPart.getName());
        System.out.println("Copies: " + numDuplicates);
        System.out.println("Individual Cost: $" + costFormat.format(identicalPart.getCost()));
        System.out.println("Individual Weight: " + weightFormat.format(identicalPart.getWeight()) + " lbs\n");
        System.out.println("Total cost: $" + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()) + " lbs\n");
        identicalPart.printBillOfMaterials();
    }
}