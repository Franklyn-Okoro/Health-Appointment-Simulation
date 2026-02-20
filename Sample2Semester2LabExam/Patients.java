
/**
 * Write a description of class Patients here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patients
{
    private String name;
    private int age;
    private String treatment;
    private int numberOfTreatments;
    
    public Patients()
    {
        String name = "";
        int age = 0;
        String treatment = "";
        int numberOfTreatments = 0;
    }
    
    public Patients(String name, int age, String treatment, int numberOfTreatments)
    {
        this.name = name;
        this.age = age;
        this.treatment = treatment;
        this.numberOfTreatments = numberOfTreatments;
    }
    
    public int getNumberOfTreatments()
    {
        return this.numberOfTreatments;
    }
    
    public void setNumberOfTreatments(int numberOfTreatments)
    {
        this.numberOfTreatments = numberOfTreatments;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String toString()
    {
        return "Name: " + this.name + "\nAge: " + this.age + 
        "\nTreatment type: " + this.treatment 
        + "\nTotal Number of Treatments: " + this.numberOfTreatments;
    }
    
    public void testToString()
    {
        System.out.println("\f");
        System.out.println(toString());
    }
}
