package service;

public class FixedDiscount extends Discount {
    @Override
    public double apply(double amount) {
        return amount - 20;
    }
}
