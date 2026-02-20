
/**
 * Write a description of class MedicalCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MedicalCard extends Patients
{
    private String medicalCardNumber;
    
    public MedicalCard()
    {
        super();
        String medicalCardNumber = "";
    }
    
    public MedicalCard(String name, int age, String treatment, int numberOfTreatments, String medicalCardNumber)
    {
        super(name, age, treatment, numberOfTreatments);
        this.medicalCardNumber = medicalCardNumber;
    }
    
    public String toString()
    {
        return super.toString() + "\nMedical Card Number: " + this.medicalCardNumber;
    }
    
    public void testToString()
    {
        System.out.println("\f");
        System.out.println(toString());
    }
}
