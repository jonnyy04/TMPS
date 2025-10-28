package lab_2.FactoryPattern;
//(Creator)
public abstract class TutoringService {

    protected abstract TutoringProduct createProduct(String subject);


    public TutoringProduct orderTutoring(String subject, String tutorName) {

        TutoringProduct product = createProduct(subject);

        product.prepareSession();
        product.scheduleTutor(tutorName);

        System.out.println(" Sesiunea a fost programata cu succes.");
        return product;
    }
}