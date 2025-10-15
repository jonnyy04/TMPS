package service;

import model.Order;

public class OrderPrinter {
    public void print(Order order) {
        System.out.println("Order amount: " + order.getAmount());
    }
}
