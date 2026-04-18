public class CreditCardPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "Kredi Karti";
    }

    @Override
    public String pay(double amount) {
        return amount + " TL Kredi Karti ile odeme yapildi.";
    }
}
