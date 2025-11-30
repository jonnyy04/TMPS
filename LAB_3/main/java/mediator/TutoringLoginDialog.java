package mediator;

public class TutoringLoginDialog implements TutoringMediator {
    private UsernameField username;
    private PasswordField password;
    private LoginButton loginButton;

    public TutoringLoginDialog() {
        this.username = new UsernameField(this);
        this.password = new PasswordField(this);
        this.loginButton = new LoginButton(this);
    }

    public UsernameField getUsername() { return username; }
    public PasswordField getPassword() { return password; }
    public LoginButton getLoginButton() { return loginButton; }

    @Override
    public void notify(Component sender, String event) {
        if (sender == loginButton && event.equals("click")) {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                System.out.println("Introdu username si parola pentru portalul de tutoring.");
            } else if (username.getText().equals("student") && password.getText().equals("tutor123")) {
                System.out.println("Bun venit pe platforma de tutoring, " + username.getText() + "!");
            } else {
                System.out.println("Credentiale incorecte.");
            }
        }
    }
}

