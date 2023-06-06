import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProcessedWindow {
    private JFrame frame;
    private JTextArea orderTextArea;
    private JButton orderDoneButton;
    private JButton backButton;

    public ProcessedWindow(List<String> orders) {
        frame = new JFrame("Processed Orders");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Processed Orders");
        titleLabel.setBounds(220, 20, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel);

        orderTextArea = new JTextArea();
        orderTextArea.setBounds(50, 60, 540, 200);
        orderTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        scrollPane.setBounds(50, 60, 540, 200);
        frame.add(scrollPane);

        StringBuilder sb = new StringBuilder();
        for (String order : orders) {
            sb.append(order).append("\n");
        }
        orderTextArea.setText(sb.toString());

        orderDoneButton = new JButton("Order Done");
        orderDoneButton.setBounds(220, 280, 100, 30);
        orderDoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOrder = orderTextArea.getSelectedText();
                if (selectedOrder != null && !selectedOrder.isEmpty()) {
                    selectedOrder = selectedOrder.replace("(processed)", "(Order Done)");

                    FileHandler processedFileHandler = new FileHandler("processed.txt");
                    processedFileHandler.writeOrder(selectedOrder);

                    FileHandler transactionsFileHandler = new FileHandler("transactions.txt");
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
        frame.add(orderDoneButton);

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
