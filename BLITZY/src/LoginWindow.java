import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton,exit;

    public LoginWindow() {
        frame = new JFrame("Login");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        Border border = BorderFactory.createLineBorder(new Color(147,112,219),3);
        Border exborder = BorderFactory.createLineBorder(new Color(255,20,147),3);


        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(360, 250, 100, 30);
        usernameLabel.setFont(new Font("Super Bubble",Font.PLAIN,13));
        frame.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(470, 250, 150, 30);
        usernameTextField.setFont(new Font("Segoe UI Black",Font.PLAIN,13));
        usernameTextField.setBorder(border);
        usernameTextField.setBackground(new Color(251,174,210));
        frame.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(360, 300, 100, 30);
        passwordLabel.setFont(new Font("Super Bubble",Font.PLAIN,13));
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(470, 300, 150, 30);
        passwordField.setBorder(border);
        passwordField.setBackground(new Color(251,174,210));
        frame.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(450,370,80,30);
        loginButton.setFont(new Font("Super Bubble",Font.PLAIN,13));
        loginButton.setBorder(border);
        loginButton.setBackground(new Color(251,174,210));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (username.equals("admin") && password.equals("123")) {
                    AdminWindow adminWindow = new AdminWindow();
                    adminWindow.display();
                    frame.dispose();
                } else if (username.equals("customer") && password.equals("123")) {
                    CustomerWindow customerWindow = new CustomerWindow();
                    customerWindow.display();
                    frame.dispose();
                } else if (username.equals("teej") && password.equals("pogi")) {
                    AdminWindow adminWindow = new AdminWindow();
                    adminWindow.display();
                    frame.dispose();
                } else if (username.equals("mark") && password.equals("pogi")) {
                    AdminWindow adminWindow = new AdminWindow();
                    adminWindow.display();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!");
                }
            }
        });
        frame.add(loginButton);
        

        exit = new JButton("X");
        exit.setBounds(975,5,20,20);
        exit.setBorder(BorderFactory.createBevelBorder(1));
        exit.setBorder(exborder);
        exit.setBackground(new Color(251,174,210));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent d) {
                frame.dispose();
                
            }
        });
        
        frame.add(exit);

        ImageIcon backgroundImage = new ImageIcon("backgrounds/mainmenu.gif");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,0,0);   
        frame.add(backgroundLabel);
        

    }


    public void display() {
        frame.setVisible(true);
    }

}
