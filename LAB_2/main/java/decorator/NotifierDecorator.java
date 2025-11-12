package decorator;


public abstract class NotifierDecorator implements INotifier {

    protected INotifier wrappee;

    public NotifierDecorator(INotifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}
