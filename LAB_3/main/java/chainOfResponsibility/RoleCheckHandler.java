package chainOfResponsibility;

public class RoleCheckHandler extends Handler {
    private TutoringDatabase db;

    public RoleCheckHandler(TutoringDatabase db) {
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password) {
        String role = db.getRole(username);

        if (role.equals("ADMIN")) {
            System.out.println("Autentificare reusita. Bine ai venit, Administrator!");
        } else if (role.equals("TUTOR")) {
            System.out.println("Autentificare reusita. Bine ai venit, Tutor!");
        } else {
            System.out.println("Autentificare reusita. Bine ai venit, Student!");
        }

        return handleNext(username, password);
    }
}

