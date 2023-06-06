import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PaidListWindow {
    private JFrame frame;
    private JTextArea orderTextArea;
    private JButton processedButton;
    private JButton backButton;

    public PaidListWindow() {
        frame = new JFrame("Paid Orders");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Paid Orders");
        titleLabel.setBounds(250, 20, 150, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel);

        orderTextArea = new JTextArea();
        orderTextArea.setBounds(50, 60, 540, 200);
        orderTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        scrollPane.setBounds(50, 60, 540, 200);
        frame.add(scrollPane);

        FileHandler fileHandler = new FileHandler("paid.txt");
        List<String> orders = fileHandler.readOrders();
        StringBuilder sb = new StringBuilder();
        for (String order : orders) {
            sb.append(order).append("\n");
        }
        orderTextArea.setText(sb.toString());

        processedButton = new JButton("Processed");
        processedButton.setBounds(220, 280, 100, 30);
        processedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOrder = orderTextArea.getSelectedText();
                if (selectedOrder != null && !selectedOrder.isEmpty()) {
                    selectedOrder = selectedOrder.replace("(paid)", "(processed)");
        
                    FileHandler processedFileHandler = new FileHandler("processed.txt");
                    processedFileHandler.writeOrder(selectedOrder);
        
                    FileHandler transactionsFileHandler = new FileHandler("paid.txt");
                    transactionsFileHandler.writeOrder(selectedOrder);

                    // Refresh the displayed orders
                    orders.remove(selectedOrder);
                    orderTextArea.setText("");
                    StringBuilder sb = new StringBuilder();
                    for (String order : orders) {
                        sb.append(order).append("\n");
                    }
                    orderTextArea.setText(sb.toString());
                }
            }
        });
        frame.add(processedButton);

        backButton = new JButton("Back");
        backButton.setBounds(340, 280, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(backButton);
    }

    public void display() {
        frame.setVisible(true);
    }

}
