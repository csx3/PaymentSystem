public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Kredi karti ile " + amount + " TL odeme alindi.");
    }
}
