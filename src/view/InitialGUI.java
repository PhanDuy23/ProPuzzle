package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class InitialGUI {

    private JFrame initialFrame = new JFrame("ProPuzzle");
    private ImageIcon userIcon = new ImageIcon("picture/go.png");
    private ImageIcon adminIcon = new ImageIcon("picture/manager.png");
    private JButton admin = new JButton(adminIcon);
    private JButton user = new JButton(userIcon);
    private JPasswordField password = new JPasswordField("admi");

    public InitialGUI() {
        initialFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initialFrame.setLayout(null);
        initialFrame.add(admin);
        initialFrame.add(user);
        initialFrame.add(password);
        setBackground();
        user.setBounds(680, 550, 120, 120);
        user.setIcon(userIcon);
        admin.setBounds(940, 540, 200, 100);
        admin.setIcon(adminIcon);
        admin.setBorder(null);
        user.setBorder(null);
        password.setBounds(1000 - 40, 640, 150, 30);
        password.setVisible(false);
        initialFrame.setLocationRelativeTo(null);
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setVisible(true);
    }

    public void setBackground() {
        ImageIcon background = new ImageIcon("picture/init.png"); // Thay đổi đường dẫn tới ảnh của bạn
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(1536, 800);
        initialFrame.add(backgroundLabel);
    }    

    public Font setFont() {
        Font x = new Font("Arial", Font.BOLD, 30);
        return x;
    }
    
    public JButton getAdminButton(){
        return admin;
    }
    public JButton getUserButton(){
        return user;
    }   
    public JPasswordField getPasswordField(){
        return password;
    }
    public JFrame getInitFrame(){
        return initialFrame;
    }
}
