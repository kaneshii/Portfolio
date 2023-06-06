import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminWindow {
    private JFrame frame;
    private JButton viewOrdersButton;
    private JButton viewProcessedButton;
    private JButton viewTransactionsButton;
    private JButton logoutButton;

    public AdminWindow() {
        frame = new JFrame("Admin Window");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.setBounds(50, 175, 180, 30);
        viewOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PaidListWindow paidListWindow = new PaidListWindow();
                paidListWindow.display();
            }
        });
        frame.add(viewOrdersButton);

        viewProcessedButton = new JButton("View Processed Orders");
        viewProcessedButton.setBounds(50, 225, 180, 30);
        viewProcessedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileHandler fileHandler = new FileHandler("processed.txt");
                List<String> orders = fileHandler.readOrders();
                ProcessedWindow processedWindow = new ProcessedWindow(orders);
                processedWindow.display();
            }
        });
        frame.add(viewProcessedButton);

        viewTransactionsButton = new JButton("View Transactions");
        viewTransactionsButton.setBounds(50, 275, 180, 30);
        viewTransactionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileHandler fileHandler = new FileHandler("transactions.txt");
                List<String> orders = fileHandler.readOrders();
                TransactionsWindow transactionsWindow = new TransactionsWindow(orders);
                transactionsWindow.display();
            }
        });
        frame.add(viewTransactionsButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 325, 180, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.display();
            }
        });
        frame.add(logoutButton);
    }

    public void display() {
        frame.setVisible(true);
    }

}
