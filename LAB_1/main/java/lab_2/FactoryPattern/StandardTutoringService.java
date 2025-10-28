package lab_2.FactoryPattern;

public class StandardTutoringService extends TutoringService {
    @Override
    protected TutoringProduct createProduct(String subject) {
        return new StandardSession(subject);
    }
}
