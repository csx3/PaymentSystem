public class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("PayPal ile " + amount + " TL odeme alindi.");
    }
}
