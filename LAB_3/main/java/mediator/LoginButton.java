package mediator;

public class LoginButton extends Component {
    public LoginButton(TutoringMediator mediator) {
        super(mediator);
    }

    public void click() {
        mediator.notify(this, "click");
    }
}

