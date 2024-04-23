package DesignPatterns.Strategy;

interface PaymentStrategy {
    void pay(int amount);
}

// Concrete implementation for PayPal payment

class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password;
    public PayPalPayment(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}


class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    public CreditCardPayment(String nm, String ccNum) {
        this.name = nm;
        this.cardNumber = ccNum;
    }
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;
    public PaymentContext(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext(new PayPalPayment("myemail@example.com", "mypassword"));
        context.executePayment(100);

        context = new PaymentContext(new CreditCardPayment("John Doe", "1234567890123456"));
        context.executePayment(200);
    }
}
