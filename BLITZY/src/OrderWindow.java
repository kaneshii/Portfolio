import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderWindow {
    private JFrame frame;
    private JComboBox<String> packageComboBox;
    private JPanel quantityPanel;
    private JLabel userDetailLabel, paymentLabel;
    private JTextField userDetailTextField;
    private JButton gcashButton, paymayaButton, bankTransferButton, takeOrderButton, backButton;

    public OrderWindow() {
        frame = new JFrame("Order Window");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.pink, 5);
        Border border1 = BorderFactory.createLineBorder(Color.pink, 2);

        JLabel packageLabel = new JLabel("Package:");
        packageLabel.setBounds(79, 75, 80, 30);
        frame.add(packageLabel);

        packageComboBox = new JComboBox<>(new String[]{"", "League RP", "Valorant Points", "Genshin Crystals", "Spotify Premium", "Netflix", "Discord Nitro"});
        packageComboBox.setBounds(79, 105, 150, 30);
        packageComboBox.setBorder(border);
        frame.add(packageComboBox);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(79, 134, 80, 30);
        frame.add(quantityLabel);

        quantityPanel = new JPanel();
        quantityPanel.setBounds(79, 164, 375, 200);
        quantityPanel.setLayout(new GridLayout(0, 2, 10, 10));
        quantityPanel.setOpaque(false);
        frame.add(quantityPanel);

        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setBounds(79, 364, 120, 30);
        frame.add(paymentMethodLabel);

        gcashButton = new JButton("GCash");
        gcashButton.setBounds(79, 394, 120, 30);
        gcashButton.setBackground(Color.white);
        gcashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentLabel.setText("GCash number: 09270610579");
            }
        });
        frame.add(gcashButton);

        paymayaButton = new JButton("PayMaya");
        paymayaButton.setBounds(259, 394, 120, 30);
        paymayaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentLabel.setText("PayMaya number: 09270610579");
            }
        });
        frame.add(paymayaButton);

        bankTransferButton = new JButton("Bank Transfer");
        bankTransferButton.setBounds(169, 442, 120, 30);
        bankTransferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentLabel.setText("Paypal: joshrivera.04@gmail.com");
            }
        });
        frame.add(bankTransferButton);

        paymentLabel = new JLabel();
        paymentLabel.setBounds(141, 486, 400, 30);
        frame.add(paymentLabel);

        takeOrderButton = new JButton("Take Order");
        takeOrderButton.setBounds(521, 280, 120, 30);
        takeOrderButton.setBorder(border1);
        takeOrderButton.setBackground(Color.white);
        takeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String packageSelected = (String) packageComboBox.getSelectedItem();
                String quantity = getSelectedQuantity();
                String userDetail = userDetailTextField.getText();

                if (packageSelected.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select a package!");
                } else if (quantity.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select a quantity!");
                } else if (userDetail.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please provide user details!");
                } else if (paymentLabel.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please select a payment method!");
                } else {
                    String order = packageSelected + " - Quantity: " + quantity + " - " + userDetail + " - " + paymentLabel.getText();
                    FileHandler fileHandler = new FileHandler("src/orders.txt");
                    fileHandler.writeOrder(order);
                    JOptionPane.showMessageDialog(frame, "Order placed successfully!");
                    frame.dispose();
                }
            }
        });
        frame.add(takeOrderButton);

        userDetailLabel = new JLabel();
        userDetailLabel.setBounds(521, 189, 400, 30);
        frame.add(userDetailLabel);

        userDetailTextField = new JTextField();
        userDetailTextField.setBounds(521, 219, 400, 30);
        userDetailTextField.setBorder(border);
        frame.add(userDetailTextField);

        packageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = (String) packageComboBox.getSelectedItem();
                generateQuantityButtons(selectedPackage);
                setUserDetailLabel(selectedPackage);
            }
        });

        backButton = new JButton("Back");
        backButton.setBounds(658, 280, 120, 30);
        backButton.setBorder(border1);
        backButton.setBackground(Color.white);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // Perform any additional back button functionality here
            }
        });
        frame.add(backButton);
    }

    public void display() {
        ImageIcon backgroundImage = new ImageIcon("backgrounds/test1.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1000, 600);
        frame.add(backgroundLabel);
        frame.setVisible(true);
    }

    private String[][] getPackageQuantities(String packageName) {
        if (packageName.equals("League RP")) {
            return new String[][]{
                    {"200 RP (PHP 46.55)"}, {"625 RP (PHP 141.55)"}, {"1525 RP (PHP 331.55)"},
                    {"2900 RP (PHP 616.55)"}, {"4600 RP (PHP 949)"}, {"10000 RP (PHP 1985)"}
            };
        } else if (packageName.equals("Valorant Points")) {
            return new String[][]{
                    {"125 VP (PHP 47)"}, {"380 VP (PHP 142)"}, {"790 VP (PHP 285)"},
                    {"1650 VP (PHP 570)"}, {"2850 VP (PHP 950)"}, {"5800 (PHP 1900)"}, {"12,500 VP(PHP 3,800)"}
            };
        } else if (packageName.equals("Genshin Crystals")) {
            return new String[][]{
                    {"60 Crystals (PHP 55)"}, {"300 Crystals (PHP 280)"}, {"980 Crystals (PHP 830)"},
                    {"1980 Crystals (PHP 1670)"}, {"3280 Crystals (PHP 2800)"}, {"6480 Crystals (PHP 5500)"},
                    {"Welkin Moon (PHP 280)"}
            };
        } else if (packageName.equals("Spotify Premium")) {
            return new String[][]{
                    {"Premium (PHP 75)"}
            };
        } else if (packageName.equals("Netflix")) {
            return new String[][]{
                    {"Solo Account (PHP 380)"}, {"Solo Profile (PHP 85)"}
            };
        } else if (packageName.equals("Discord Nitro")) {
            return new String[][]{
                    {"1 Nitro boost (PHP 150)"}, {"2 Nitro boost (PHP 150)"}
            };
        }
        return new String[0][0];
    }

    private void initializeQuantityButtons(String[][] quantities) {
        for (String[] quantity : quantities) {
            JButton button = new JButton(quantity[0]);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resetQuantityButtons();
                    button.setEnabled(false);
                }
            });
            quantityPanel.add(button);
        }
    }

    private void generateQuantityButtons(String selectedPackage) {
        quantityPanel.removeAll();

        String[][] quantities = getPackageQuantities(selectedPackage);
        initializeQuantityButtons(quantities);

        frame.revalidate();
        frame.repaint();
    }

    private void setUserDetailLabel(String selectedPackage) {
        if (selectedPackage.equals("League RP") || selectedPackage.equals("Valorant Points")) {
            userDetailLabel.setText("Please provide user details (ex. Teej#pogi)");
        } else if (selectedPackage.equals("Genshin Crystals")) {
            userDetailLabel.setText("Please provide UID (ex. 801985911)");
        } else if (selectedPackage.equals("Spotify Premium") || selectedPackage.equals("Netflix")) {
            userDetailLabel.setText("Please provide an email (we will send the account through your email)");
        } else if (selectedPackage.equals("Discord Nitro")) {
            userDetailLabel.setText("Please provide your Discord ID (ex. matty#0512)");
        } else {
            userDetailLabel.setText("");
        }
    }

    private String getSelectedQuantity() {
        Component[] buttons = quantityPanel.getComponents();
        for (Component button : buttons) {
            if (button instanceof JButton) {
                if (!((JButton) button).isEnabled()) {
                    return ((JButton) button).getText();
                }
            }
        }
        return "";
    }

    private void resetQuantityButtons() {
        Component[] buttons = quantityPanel.getComponents();
        for (Component button : buttons) {
            if (button instanceof JButton) {
                button.setEnabled(true);
            }
        }
    }
}
