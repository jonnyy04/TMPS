package decorator;

public class WhatsAppDecorator extends NotifierDecorator {

    private String phoneNumber;

    public WhatsAppDecorator(INotifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message); // trimite email-ul (comportamentul de baza)
        System.out.println("[WhatsApp] Sending to " + phoneNumber + ": " + message);
    }
}

