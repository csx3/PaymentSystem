public class PayPalPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "PayPal";
    }

    @Override
    public String pay(double amount) {
        return amount + " TL PayPal ile odeme yapildi.";
    }
}
