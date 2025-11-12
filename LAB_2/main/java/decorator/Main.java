package decorator;

public class Main {
    public static void main(String[] args) {

        // doar Email
        INotifier emailNotifier = new EmailNotifier("maria@student.com");
        emailNotifier.send("Your tutoring session starts at 10:00.");

        System.out.println("\n---\n");

        // Email + WhatsApp
        INotifier whatsappNotifier = new WhatsAppDecorator(
                new EmailNotifier("andrei@tutor.com"),
                "+40712345678"
        );
        whatsappNotifier.send("Reminder: your session starts at 13:00.");

        System.out.println("\n---\n");

        // Email + WhatsApp + SMS
        INotifier fullNotifier = new SMSDecorator(
                new WhatsAppDecorator(
                        new EmailNotifier("ioana@student.com"),
                        "+40798765432"
                ),
                "+40798765432"
        );
        fullNotifier.send("Your tutoring session has been rescheduled to 17:00.");
    }
}

