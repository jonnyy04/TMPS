package mediator;

public class PasswordField extends Component {
    private String text = "";

    public PasswordField(TutoringMediator mediator) {
        super(mediator);
    }

    public void setText(String t) {
        text = t;
        mediator.notify(this, "text");
    }

    public String getText() {
        return text;
    }
}

