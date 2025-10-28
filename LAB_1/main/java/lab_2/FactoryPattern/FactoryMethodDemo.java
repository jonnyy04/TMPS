package lab_2.FactoryPattern;

public class FactoryMethodDemo {
    public static void main(String[] args) {

        System.out.println("--- PROGRAMARE SERVICIU STANDARD ---");

        TutoringService standardService = new StandardTutoringService();

        standardService.orderTutoring("Matematica", "Dl. Andrei");

        System.out.println("\n====================================");

        System.out.println("--- PROGRAMARE SERVICIU PREMIUM ---");
        TutoringService premiumService = new PremiumTutoringService();

        premiumService.orderTutoring("Fizica Cuantica", "Dr. Elena");

    }
}