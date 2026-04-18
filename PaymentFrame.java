import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PaymentFrame extends JFrame {
    private final PaymentService paymentService;
    private final PaymentMethod[] paymentMethods;
    private final JComboBox<String> paymentMethodComboBox;
    private final JTextField amountField;
    private final JLabel resultLabel;

    public PaymentFrame(PaymentService paymentService, PaymentMethod[] paymentMethods) {
        this.paymentService = paymentService;
        this.paymentMethods = paymentMethods;

        setTitle("Odeme Ekrani");
        setSize(620, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(30, 40, 30, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel paymentMethodLabel = new JLabel("Odeme Yontemi:");
        paymentMethodLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panel.add(paymentMethodLabel, gbc);

        paymentMethodComboBox = new JComboBox<>(createPaymentMethodNames());
        paymentMethodComboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        panel.add(paymentMethodComboBox, gbc);

        JLabel amountLabel = new JLabel("Tutar:");
        amountLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(amountLabel, gbc);

        amountField = new JTextField();
        amountField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        panel.add(amountField, gbc);

        JButton payButton = new JButton("Odeme Yap");
        payButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        payButton.addActionListener(event -> handlePayment());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.ipady = 12;
        panel.add(payButton, gbc);

        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        resultLabel.setForeground(new Color(55, 71, 79));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.ipady = 0;
        gbc.insets = new Insets(30, 12, 12, 12);
        panel.add(resultLabel, gbc);

        setContentPane(panel);
    }

    private String[] createPaymentMethodNames() {
        String[] names = new String[paymentMethods.length];

        for (int i = 0; i < paymentMethods.length; i++) {
            names[i] = paymentMethods[i].getName();
        }

        return names;
    }

    private void handlePayment() {
        String amountText = amountField.getText().trim();

        if (amountText.isEmpty()) {
            resultLabel.setText("Lutfen bir tutar girin.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException exception) {
            resultLabel.setText("Gecerli bir sayisal tutar girin.");
            return;
        }

        if (amount <= 0) {
            resultLabel.setText("Tutar sifirdan buyuk olmali.");
            return;
        }

        PaymentMethod selectedPaymentMethod = paymentMethods[paymentMethodComboBox.getSelectedIndex()];
        String result = paymentService.processPayment(selectedPaymentMethod, amount);
        resultLabel.setText(result);
    }
}
