package lab_2.FactoryPattern;

public class PremiumTutoringService extends TutoringService {
    @Override
    protected TutoringProduct createProduct(String subject) {
        return new PremiumSession(subject);
    }
}
