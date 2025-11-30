package mediator;

public abstract class Component {
    protected TutoringMediator mediator;

    public Component(TutoringMediator mediator) {
        this.mediator = mediator;
    }
}
