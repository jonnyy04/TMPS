package chainOfResponsibility;

public class ValidPasswordHandler extends Handler {
    private TutoringDatabase db;

    public ValidPasswordHandler(TutoringDatabase db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!db.isPasswordValid(username, password)) {
            System.out.println("Parola incorecta.");
            return false;
        }
        return handleNext(username, password);
    }
}

