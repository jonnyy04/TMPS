package lab_2.FactoryPattern;

public class PremiumSession implements TutoringProduct {
    private final String subject;

    public PremiumSession(String subject) {
        this.subject = subject;
        System.out.println("  -> Creare Sesiune PREMIUM pentru " + subject);
    }

    @Override
    public void prepareSession() {
        System.out.println("  -> PREMIUM: Prepara materialele avansate, inregistrare activata si suport dedicat.");
    }

    @Override
    public void scheduleTutor(String tutorName) {
        System.out.println("  -> PREMIUM: Aloca profesorul expert " + tutorName + " cu durata de 90 de minute.");
    }
}
