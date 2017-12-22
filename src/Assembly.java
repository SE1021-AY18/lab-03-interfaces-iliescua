/*
*Course: SE1021
*Winter 2017
*Lab 3
*Name: Andrew Iliescu
*Project: Assembly Class
*Created: 12/13/2017
*/
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Assembly implements Part {
    private DecimalFormat costFormat = new DecimalFormat("0.00");//formats the cost result
    private DecimalFormat weightFormat = new DecimalFormat("##0.###");//formats the weight result
    private ArrayList<Part> subParts = new ArrayList();//creates an ArrayList of Part called subParts
    static final double USD_PER_SUB_PART = 0.25;//constant for the cost multiplier of subParts
    private double cost;//stores the cost value
    private String name;//stores the name

    public Assembly(String name) {
        this.name = name;
    }

    /**
     * called in order to add a part to subParts ArrayList
     * @param part gets added to subParts
     */
    public void addPart(Part part) {
        subParts.add(part);
    }

    /**
     * calculates and returns the value of cost
     * @return the value of cost
     */
    public double getCost() {
        cost = USD_PER_SUB_PART * subParts.size();
        for (int i = 0; i < subParts.size(); i++) {
            cost += subParts.get(i).getCost();
        }
        return cost;
    }

    /**
     * returns the name to be displayed
     * @return name so it can be displayed
     */
    public String getName() {
        return name;
    }

    /**
     * calculates the weight and returns it
     * @return the weight value
     */
    public double getWeight() {
        double weight = 0;//stores the weight value
        for (int i = 0; i < subParts.size(); i++) {
            weight += subParts.get(i).getWeight();
        }
        return weight;
    }

    /**
     * used to print out the weight, cost, name of the part
     * and the total cost and total weight of the object
     */
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");

        for (Part part : subParts) {
            System.out.println("Part: " + part.getName());
            System.out.println("Cost: $" + costFormat.format(part.getCost()));
            System.out.println("Weight: " + weightFormat.format(part.getWeight()) + " lbs");
            System.out.println();
        }

        System.out.println("Total cost: $" + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()) + " lbs");
        System.out.println();

        for (Part part : subParts) {
            part.printBillOfMaterials();
        }
    }
}