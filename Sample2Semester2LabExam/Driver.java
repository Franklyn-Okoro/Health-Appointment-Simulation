import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    ArrayList<Patients> patient;
    ArrayList<Treatments> appointment;
    public Driver()
    {
        appointment = new ArrayList<Treatments>();
        patient = new ArrayList<Patients>();

        System.out.println("\f");
        inputTreatments();
        inputPatients();
        multipleNonMedicalTreatments();
        displayXRayPatients();
    }

    public void inputTreatments()
    {
        Scanner scan = new Scanner(System.in);
        String treatmentName = "";
        double basicCosts = 40;
        double addedCosts = 0;
        boolean xRay = true;
        double fullCosts = 0;
        Treatments t;

        System.out.println("Adding a new Treatment...");
        for(int i = 0;i < 1; i++)
        {
            System.out.println("\nWhat type of treatment will be needed?(physio, apply bandage, change dressing, apply cast");
            treatmentName = scan.nextLine();
            // a loop that forces the user to input one of the 4 values in the question
            if(treatmentName.equalsIgnoreCase("physio") || treatmentName.equalsIgnoreCase("apply bandage") ||
            treatmentName.equalsIgnoreCase("change dressing") || treatmentName.equalsIgnoreCase("apply cast"))
            {
                System.out.println("\nThe standing charge of a treatment will be $" + basicCosts);
                System.out.println("\nHow much will be the cost for added costs be?");
                addedCosts = scan.nextDouble();
                scan.nextLine();
                System.out.println("\nWill an x-ray be needed in this treatment(enter true or false):");
                xRay = scan.nextBoolean();
                scan.nextLine();
                // an if statement that adds $85 to the added costs if there is an x-ray needed
                if(xRay == true)
                {
                    addedCosts = addedCosts + 85;
                    System.out.println("\nThe updated value of added costs is now "  + addedCosts);
                }
                else
                {
                    System.out.println("\nNo x-ray will be needed and no additional costs will be added!");
                }
                fullCosts = basicCosts + addedCosts;
                System.out.println("\nThe total cost for this treatment will be $" + fullCosts);

                t = new Treatments(treatmentName, basicCosts, addedCosts, xRay, fullCosts);
                appointment.add(t);               
            }
            else
            {
                //else an error message is displayed that allows the user to try another type of treatment
                System.out.println("\nERROR, please enter the right kind of treatment!!");
            }
        }
    }

    public void inputPatients()
    {
        Scanner scan = new Scanner(System.in);
        String name = "";
        int age = 0;
        String treatment = "";
        int numberOfTreatments = 0;
        String privHealthInsurer = "";//non medical
        String medicalCardNumber = "";//medical
        String reply = "";
        MedicalCard mc;
        NonMedicalCard nmc;

        System.out.println("\nAdding a new Patient...");
        //Adding three types of patients to the list of patients
        for(int i = 0;i < 1; i++)
        {
            //ask user if they have a medical card
            System.out.println("\nDo you have a medical card?(yes or no)");
            reply = scan.nextLine();
            if(reply.equalsIgnoreCase("yes"))
            {
                System.out.println("\nEnter your name?");
                name = scan.nextLine();
                System.out.println("\nEnter your age?");
                age = scan.nextInt();
                scan.nextLine();
                System.out.println("\nWhat type of treatment will be needed?(physio, apply bandage, change dressing, apply cast");
                treatment = scan.nextLine();
                //add a function that validates the name in any of the treatment lists to confirm its one of the treatments options
                for(Treatments t: appointment)
                {
                    if(treatment.equalsIgnoreCase(t.getTreatmentName()))
                    {
                        System.out.println("\nThe name matches with one of the items on the treatments list");
                    }
                    else
                    {
                        //else print a statement that shows no treatment in the list
                        System.out.println("\nThere is no treatment with the name you entered");
                    } 
                }
                System.out.println("\nEnter how many treatments you have taken in total?(must be between 0-5)");
                numberOfTreatments = scan.nextInt();
                scan.nextLine();
                //another loop that makes sure the user doesn't go out of the limit
                if(numberOfTreatments >= 0 && numberOfTreatments <= 5)
                {
                    System.out.println("\nThe value entered is between the criteria");
                }
                else
                {
                    System.out.println("\nError, the number of treatments can't be greater than 5");
                    System.out.println("\nEnter how many treatments you have taken in total?(must be between 0-5)");
                    numberOfTreatments = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("\nEnter your medical card number?");
                medicalCardNumber = scan.nextLine();

                //adding variables to the list
                mc = new MedicalCard(name, age, treatment, numberOfTreatments, medicalCardNumber);
                patient.add(mc);
            }
            else if(reply.equalsIgnoreCase("no"))
            {
                System.out.println("\nEnter your name?");
                name = scan.nextLine();
                System.out.println("\nEnter your age?");
                age = scan.nextInt();
                scan.nextLine();
                System.out.println("\nWhat type of treatment will be needed?(physio, apply bandage, change dressing, apply cast");
                treatment = scan.nextLine();
                //add a function that validates the name in any of the treatment lists to confirm its one of the treatments options
                for(Treatments t: appointment)
                {
                    if(treatment.equalsIgnoreCase(t.getTreatmentName()))
                    {
                        System.out.println("\nThe name matches with one of the items on the treatments list");
                    }
                    else
                    {
                        //else print a statement that shows no treatment in the list
                        System.out.println("\nThere is no treatment with the name you entered");
                    } 
                }
                System.out.println("\nEnter how many treatments you have taken in total?");
                numberOfTreatments = scan.nextInt();
                scan.nextLine();
                System.out.println("\nWhats the name of the private health insurer?");
                privHealthInsurer = scan.nextLine();

                //adding variables to the list
                nmc = new NonMedicalCard(name, age, treatment, numberOfTreatments, privHealthInsurer);
                patient.add(nmc);
            }

            else
            {
                System.out.println("\nError, you have entered a value that is not yes or no?");
            }
        }
    }

    public void multipleNonMedicalTreatments()
    {
        int totalTreatments = 0;
        NonMedicalCard nmc;

        //display the details of non-medical card patients who have went to 10 or more treatments 
        for(Patients p: patient)
        {
            if(p instanceof NonMedicalCard)
            {
                nmc = (NonMedicalCard) p;
                totalTreatments = p.getNumberOfTreatments();
                if(p.getNumberOfTreatments() > 10)
                {
                    System.out.println(p.toString());
                }
            }
        }
    }

    public void displayXRayPatients()
    {
        //display the the treatment name and full cost of treatments that require an x-ray
        for(Treatments t: appointment)
        {
            if(t.getXRay() == true)
            {
                System.out.println("\nThe name of the treatment is " + t.getTreatmentName());
                System.out.println("The total cost of the treatment will be $" + t.getFullCosts());
            }
            else
            {
                System.out.println("\nThere were no treatments that required an X-ray");
            }
        }
    }

    public static void main (String [] args)
    {
        new Driver();
    }
}
