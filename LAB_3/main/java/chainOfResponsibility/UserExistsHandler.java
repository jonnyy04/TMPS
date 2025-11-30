package chainOfResponsibility;

public class UserExistsHandler extends Handler {
    private TutoringDatabase db;

    public UserExistsHandler(TutoringDatabase db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!db.userExists(username)) {
            System.out.println("Utilizatorul nu exista. Creeaza un cont.");
            return false;
        }
        return handleNext(username, password);
    }
}

