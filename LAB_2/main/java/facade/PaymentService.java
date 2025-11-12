package facade;

public class PaymentService {

    public boolean processPayment(String studentName, double amount) {
        System.out.println("[Payment] Processing payment of $" + amount + " from student " + studentName);
        // simulare: plata reușește mereu
        return true;
    }
}
