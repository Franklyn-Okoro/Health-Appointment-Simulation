import java.util.Scanner;
/**
 * Write a description of class Treatments here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Treatments
{
    private String treatmentName;
    private double basicCosts;
    private double addedCosts;
    private boolean xRay;
    private double fullCosts;

    public Treatments()
    {
        String treatmentName = "";
        double basicCosts = 0;
        double addedCosts = 0;
        boolean xRay = true;
        double fullCosts = 0;
    }
    
    public Treatments(String treatmentName, double basicCosts, 
    double addedCosts, boolean xRay, double fullCosts)
    {
        this.treatmentName = treatmentName;
        this.basicCosts = basicCosts;
        this.addedCosts = addedCosts;
        this.xRay = xRay;
        this.fullCosts = fullCosts;
    }
    
    public String getTreatmentName()
    {
        return this.treatmentName;
    }
    
    public void setTreatmentName(String treatmentName)
    {
        this.treatmentName = treatmentName;
    }
    
    public void xRayValue()
    {
        Scanner scan = new Scanner(System.in);
        String response = "";
        
        System.out.println("Does this treatment require an x-ray?(yes or no)");
        response = scan.nextLine();
        
        if(response.equalsIgnoreCase("yes"))
        {
            xRay = true;
            this.addedCosts = this.addedCosts + 85;          
            System.out.println("There is an x-ray needed,added cost will be " + this.addedCosts);           
        }
        else if(response.equalsIgnoreCase("no"))
        {
            xRay = false;
            System.out.println("There was no x-ray needed for this treatment");
        }
        this.fullCosts = this.fullCosts + this.basicCosts + this.addedCosts;
    }
    
    public boolean getXRay()
    {
        return this.xRay;
    }
    
    public void setXRay(boolean xRay)
    {
        this.xRay = xRay;
    }
    
    public double getFullCosts()
    {
        return this.fullCosts;
    }
    
    public void setFullCosts(double fullCosts)
    {
        this.fullCosts = fullCosts;
    }
    
    public String toString()
    {
        return "Treatment Name: " + this.treatmentName + "\nBasic Costs: " + 
        this.basicCosts + "\nAdditional Costs: " + this.addedCosts + 
        "\nX-ray needed: " + this.xRay + "\nTotal Costs: " +
        this.fullCosts;
    }
    
    public void testToString()
    {
        System.out.println("\f");
        System.out.println(toString());
    }
}
