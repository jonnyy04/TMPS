package decorator;


public class EmailNotifier implements INotifier {

    private String userEmail;

    public EmailNotifier(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public void send(String message) {
        System.out.println("[Email] Sending to " + userEmail + ": " + message);
    }
}
