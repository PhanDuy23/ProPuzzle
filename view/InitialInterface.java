package view;

import controller.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class InitialInterface {

    private JFrame initialFrame = new JFrame("ProPuzzle");
    private JButton admin = new JButton("admin");
    private JButton user = new JButton("user");
    private JPasswordField password = new JPasswordField("password admin");

    public InitialInterface() {
        initialFrame.setSize(400, 500);
        initialFrame.setLayout(null);
        initialFrame.add(admin);
        initialFrame.add(user);
        initialFrame.add(password);
        admin.setBounds(150, 210, 100, 50);
        user.setBounds(150, 100, 100, 50);
        password.setBounds(130, 270, 150, 30);
        initialFrame.setVisible(true);
        listenAction();
    }

    public void listenAction() {
        admin.addActionListener((ActionEvent e) -> {
//            initialFrame.setVisible(false);
            HandleAdmin x = new HandleAdmin();
            if (x.checkPassword(password.getText())) {
                AdminInterface admin = new AdminInterface();
            } else {
                System.out.println(x.checkPassword(password.getText()) + " " + password.getText());
            }

        });

        user.addActionListener((ActionEvent e) -> {
//            initialFrame.setVisible(false);
            UserInterface userInterface = new UserInterface();

        });
    }

}
