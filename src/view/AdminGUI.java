package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class AdminGUI {

    private final JFrame adminFrame = new JFrame("ProPuzzle");
    private final JButton add = new JButton("Add");
    private final JButton find = new JButton("Find");
    private final JButton fix = new JButton("Repair");
    private final JButton delete = new JButton("Delete");
    private final JLabel text = new JLabel("  Chức năng Admin");

    public AdminGUI() {
        adminFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        add.setBounds(400, 300, 150, 50);
        fix.setBounds(600, 300, 150, 50);
        find.setBounds(800, 300, 150, 50);
        delete.setBounds(1000, 300, 150, 50);      
        text.setBounds(500, 150, 600, 100);
        text.setFont(new Font("Arial", Font.BOLD, 50));
        adminFrame.add(text);
        adminFrame.add(add);
        adminFrame.add(find);
        adminFrame.add(fix);
        adminFrame.add(delete);
        setBackground();
        adminFrame.setLayout(null);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(false);
    }

    
    public void setBackground() {
        ImageIcon background = new ImageIcon("picture/adminbackground.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(1536, 840);  // 1536 864
        adminFrame.add(backgroundLabel);
    }
    
    public JFrame getAdminFrame(){
        return adminFrame;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getFind() {
        return find;
    }

    public JButton getFix() {
        return fix;
    }
    
}
