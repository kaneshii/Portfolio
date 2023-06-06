import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;


public class TransactionsWindow {
    private JFrame frame;
    private JTextArea orderTextArea;
    private JButton backButton;

    public TransactionsWindow(List<String> orders) {
        frame = new JFrame("Transactions");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Transactions");
        titleLabel.setBounds(215, 140, 250, 30);
        titleLabel.setFont(new Font("Super Bubble", Font.BOLD, 20));
        frame.add(titleLabel);

        orderTextArea = new JTextArea();
        orderTextArea.setBounds(215, 183, 570, 200);
        orderTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        scrollPane.setBounds(215, 183, 540, 200);
        frame.add(scrollPane);

        StringBuilder sb = new StringBuilder();
        for (String order : orders) {
            sb.append(order).append("\n");
        }
        orderTextArea.setText(sb.toString());

        backButton = new JButton("Back");
        backButton.setBounds(12, 12, 100, 30);
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
