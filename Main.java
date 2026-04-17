public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        PaymentMethod creditCardPayment = new CreditCardPayment();
        PaymentMethod payPalPayment = new PayPalPayment();

        paymentService.processPayment(creditCardPayment, 1500);
        paymentService.processPayment(payPalPayment, 750);
    }
}
