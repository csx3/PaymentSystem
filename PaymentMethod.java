public interface PaymentMethod {
    String getName();

    String pay(double amount);
}
