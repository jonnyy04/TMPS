package service;

public class PercentageDiscount extends Discount {
    @Override
    public double apply(double amount) {
        return amount * 0.9;
    }
}
