import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderListWindow {
    private JFrame frame;
    private JTextArea orderListTextArea;
    private JLabel remainingOrdersLabel,remainingOrdersLabel1;
    private JButton backButton,paidButton;

    public OrderListWindow(List<String> orders) {
        frame = new JFrame("Order List Window");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        orderListTextArea = new JTextArea();
        orderListTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderListTextArea);
        scrollPane.setBounds(215, 172, 570, 200);
        frame.add(scrollPane);

        remainingOrdersLabel = new JLabel("Please pay these remaining orders for them to be processed");
        remainingOrdersLabel.setBounds(328, 130, 344, 30);
        frame.add(remainingOrdersLabel);

        remainingOrdersLabel1 = new JLabel("(Highlight the order and press paid button to if completed)");
        remainingOrdersLabel1.setBounds(333, 148, 333, 30);
        frame.add(remainingOrdersLabel1);


        paidButton = new JButton("Paid");
        paidButton.setBounds(446, 397, 100, 30);
        paidButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOrder = orderListTextArea.getSelectedText();
                if (selectedOrder != null) {
                    String updatedOrder = selectedOrder + " (paid)";
                    int startIndex = orderListTextArea.getSelectionStart();
                    int endIndex = orderListTextArea.getSelectionEnd();
                    orderListTextArea.replaceRange(updatedOrder, startIndex, endIndex);

                    try {
                        FileWriter writer = new FileWriter("paid.txt", true);
                        writer.write(updatedOrder + "\n");
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        frame.add(paidButton);

        backButton = new JButton("Back");
        backButton.setBounds(13, 13, 100, 30);
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton);

        displayOrders(orders);
    }

    private void displayOrders(List<String> orders) {
        StringBuilder sb = new StringBuilder();
        for (String order : orders) {
            sb.append(order).append("\n");
        }
        orderListTextArea.setText(sb.toString());
    }

    public void display() {
        frame.setVisible(true);
    }

}
