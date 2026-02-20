    
/**
 * Write a description of class NonMedicalCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NonMedicalCard extends Patients
{
    private String privHealthInsurer;
    
    public NonMedicalCard()
    {
        super();
        String privHealthInsurer = "";
    }
    
    public NonMedicalCard(String name, int age, String treatment, int numberOfTreatments, String privHealthInsurer)
    {
        super(name, age, treatment, numberOfTreatments);
        this.privHealthInsurer = privHealthInsurer;
    }
    
    public String toString()
    {
        return super.toString() + "\nName of Private Health Insurer: " + this.privHealthInsurer;
    }
    
    public void testToString()
    {
        System.out.println("\f");
        System.out.println(toString());
    }
}
