public class Main {
    public static void main(String[] args) {
        PaymentMethod[] paymentMethods = {
                new CreditCardPayment(),
                new PayPalPayment()
        };
        PaymentService paymentService = new PaymentService();

        javax.swing.SwingUtilities.invokeLater(() -> {
            PaymentFrame frame = new PaymentFrame(paymentService, paymentMethods);
            frame.setVisible(true);
        });
    }
}
