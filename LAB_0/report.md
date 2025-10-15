# SOLID Principles Implementation Report

**Author:** Vornicescu Ion

## Objectives:
* Get familiar with the SOLID Principles;
* Choose a specific domain;
* Implement at least 3 SOLID principles for the specific domain;

## Domain
The chosen domain is an **Order Management System** that handles order processing, discounts application, and payment processing.

## Implemented SOLID Principles:

### 1. Single Responsibility Principle (S)
### 2. Open/Closed Principle (O)
### 3. Dependency Inversion Principle (D)

## Implementation

### Single Responsibility Principle (S)

The Single Responsibility Principle states that a class should have only one reason to change. In this implementation, the `OrderPrinter` class has a single responsibility: printing order information. It doesn't handle order creation, discount calculations, or payment processing.

**OrderPrinter.java:**
```java
package service;

import model.Order;

public class OrderPrinter {
    public void print(Order order) {
        System.out.println("Order amount: " + order.getAmount());
    }
}
```

Similarly, the `Order` class only manages order data:

**Order.java:**
```java
package model;

public class Order {
    private double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
```

### Open/Closed Principle (O)

The Open/Closed Principle states that software entities should be open for extension but closed for modification. The `Discount` abstract class demonstrates this principle by allowing new discount types to be added without modifying the existing base class.

**Discount.java:**
```java
package service;

public abstract class Discount {
    public abstract double apply(double amount);
}
```

New discount types can be added by extending the base class:

**PercentageDiscount.java:**
```java
package service;

public class PercentageDiscount extends Discount {
    @Override
    public double apply(double amount) {
        return amount * 0.9; 
    }
}
```

**FixedDiscount.java:**
```java
package service;

public class FixedDiscount extends Discount {
    @Override
    public double apply(double amount) {
        return amount - 20;
    }
}
```

### Dependency Inversion Principle (D)

The Dependency Inversion Principle states that high-level modules should not depend on low-level modules; both should depend on abstractions. The `PaymentProcessor` class depends on the `PaymentMethod` interface rather than concrete payment implementations.

**PaymentMethod.java (Abstraction):**
```java
package service;

public interface PaymentMethod {
    void pay(double amount);
}
```

**PaymentProcessor.java (High-level module):**
```java
package service;

public class PaymentProcessor {
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.pay(amount);
    }
}
```

**CreditCardPayment.java (Low-level module):**
```java
package service;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card.");
    }
}
```

### Main Application

The main application demonstrates how all these principles work together:

**Main.java:**
```java
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
```

## Results

**Expected Output:**
```
Order amount: 200.0
After discount: 180.0
Paid 180.0 using credit card.
```

The implementation successfully demonstrates:
- **SRP**: Each class has a single, well-defined responsibility
- **OCP**: New discount types can be added without modifying existing code
- **DIP**: The payment processor depends on abstractions, making it easy to swap payment methods

## Conclusions

The implementation of SOLID principles significantly improves the code quality and maintainability of the Order Management System:

1. **Single Responsibility Principle** ensures that each class has a clear purpose, making the code easier to understand and maintain.

2. **Open/Closed Principle** allows the system to be extended with new discount types without modifying existing, tested code, reducing the risk of introducing bugs.

3. **Dependency Inversion Principle** creates loose coupling between components, making it easy to add new payment methods (e.g., PayPal, Bitcoin) without changing the `PaymentProcessor` class.

These principles work together to create a flexible, maintainable, and scalable system that can easily adapt to changing business requirements. The modular design allows for easy testing, as each component can be tested independently with mock implementations.