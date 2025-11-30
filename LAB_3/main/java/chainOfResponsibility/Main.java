package chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        TutoringDatabase db = new TutoringDatabase();

        Handler chain = new UserExistsHandler(db);
        chain.setNext(new ValidPasswordHandler(db))
                .setNext(new RoleCheckHandler(db));

        AuthService auth = new AuthService(chain);

        auth.login("student1", "pass123");
        System.out.println();

        auth.login("tutorA", "wrong");
        System.out.println();

        auth.login("admin", "root");
        System.out.println();
    }
}
