package view;

import controller.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class InitialInterface {

    private JFrame initialFrame = new JFrame("ProPuzzle");
    private JButton admin = new JButton("admin");
    private JButton user = new JButton("user");
    private JPasswordField password = new JPasswordField("admin");
    private String click;

    public InitialInterface() {
        initialFrame.setSize(400, 500);
        initialFrame.setLayout(null);
        initialFrame.add(admin);
        initialFrame.add(user);
        initialFrame.add(password);
        admin.setBounds(150, 210, 100, 50);
        user.setBounds(150, 100, 100, 50);
        password.setBounds(130, 270, 150, 30);
        initialFrame.setLocationRelativeTo(null);
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.getContentPane().setBackground(Color.pink); 
        initialFrame.setVisible(false);
       
    }

    public void listenActionInitial(AdminInterface adminInterface, UserInterface userInterface) {
        admin.addActionListener((ActionEvent e) -> {
            HandleAdmin x = new HandleAdmin();
            if (x.checkPassword(password.getText())) {
                adminInterface.setAdminFrame(true);
                initialFrame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(initialFrame, "sai mật khẩu");
            }
        });

        user.addActionListener((ActionEvent e) -> {                        
                userInterface.setUserFrame(true);
                initialFrame.setVisible(false);
        });
    }

    public String getClick() {
        return click;
    }

    public void setInitialFrame(boolean x) {
        initialFrame.setVisible(x);
    }

}
