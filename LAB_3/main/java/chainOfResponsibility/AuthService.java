package chainOfResponsibility;

public class AuthService {
    private Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public void login(String username, String password) {
        if (handler.handle(username, password)) {
            System.out.println("Acces permis la platforma de tutoring.");
        }
    }
}

