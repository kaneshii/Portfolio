import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class CustomerWindow {
    private JFrame frame;
    private JButton orderButton;
    private JButton viewOrderButton;
    private JButton viewTransactionsButton;
    private JButton logoutButton;

    public CustomerWindow() {
        frame = new JFrame("Customer Window");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        orderButton = new JButton("Place Order");
        orderButton.setBounds(50, 175, 150, 30);
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderWindow orderWindow = new OrderWindow();
                orderWindow.display();
            }
        }); 
        frame.add(orderButton);

        viewOrderButton = new JButton("View Orders");
        viewOrderButton.setBounds(50, 225, 150, 30);
        viewOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileHandler fileHandler = new FileHandler("src/orders.txt");
                List<String> orders = fileHandler.readOrders();
                OrderListWindow orderListWindow = new OrderListWindow(orders);
                orderListWindow.display();
            }
        });
        frame.add(viewOrderButton);

        viewTransactionsButton = new JButton("View Transactions");
        viewTransactionsButton.setBounds(50, 275, 150, 30);
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
        logoutButton.setBounds(50, 325, 150, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform logout operation here
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
