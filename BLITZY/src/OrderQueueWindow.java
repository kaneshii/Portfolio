import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderQueueWindow {
    private JFrame frame;
    private JTextArea orderQueueTextArea;

    public OrderQueueWindow() {
        frame = new JFrame("Order Queue");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        orderQueueTextArea = new JTextArea();
        orderQueueTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(orderQueueTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public void display() {
        orderQueueTextArea.setText("");
        readOrdersFromFile();
        frame.setVisible(true);
    }

    private void readOrdersFromFile() {
        try {
            FileReader reader = new FileReader("orders.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            orderQueueTextArea.setText(sb.toString());

            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error reading orders from file.");
        }
    }
}
