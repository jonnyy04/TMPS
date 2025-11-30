package mediator;

public class UsernameField extends Component {
    private String text = "";

    public UsernameField(TutoringMediator mediator) {
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

