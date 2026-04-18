public class PaymentService {
    public String processPayment(PaymentMethod paymentMethod, double amount) {
        return paymentMethod.pay(amount);
    }
}
