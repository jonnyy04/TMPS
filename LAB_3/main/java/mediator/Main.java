package mediator;

public class Main {
    public static void main(String[] args) {
        TutoringLoginDialog dialog = new TutoringLoginDialog();

        dialog.getUsername().setText("student");
        dialog.getPassword().setText("tutor123");

        dialog.getLoginButton().click();
    }
}

