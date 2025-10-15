import model.Order;
import service.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(200);
        OrderPrinter printer = new OrderPrinter();
        printer.print(order);

        Discount discount = new PercentageDiscount();
        double finalAmount = discount.apply(order.getAmount());
        System.out.println("After discount: " + finalAmount);

        PaymentMethod payment = new CreditCardPayment();
        PaymentProcessor processor = new PaymentProcessor(payment);
        processor.process(finalAmount);
    }
}
