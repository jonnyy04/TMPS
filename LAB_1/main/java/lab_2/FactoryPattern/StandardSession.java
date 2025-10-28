package lab_2.FactoryPattern;

public class StandardSession implements TutoringProduct {
    private final String subject;

    public StandardSession(String subject) {
        this.subject = subject;
        System.out.println("  -> Creare Sesiune Standard pentru " + subject);
    }

    @Override
    public void prepareSession() {
        System.out.println("  -> Standard: Pregateste materialele de baza si sala virtuala.");
    }

    @Override
    public void scheduleTutor(String tutorName) {
        System.out.println("  -> Standard: Aloca profesorul " + tutorName + " cu durata de 60 de minute.");
    }
}
