package decorator;

public class SMSDecorator extends NotifierDecorator {

    private String phoneNumber;

    public SMSDecorator(INotifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message); // notificarea de la clasa parinte
        System.out.println("[SMS] Sending to " + phoneNumber + ": " + message);
    }
}

