package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class AdminInterface {

    private final JFrame adminFrame = new JFrame("ProPuzzle");
    private final JButton add = new JButton("Add");
    private final JButton find = new JButton("Find");
    private final JButton fix = new JButton("Fix");
    private final JButton delete = new JButton("Delete");
    private final JLabel text = new JLabel("  Chức năng Admin");

    public AdminInterface() {
        adminFrame.setSize(400, 500);
        add.setBounds(125, 100, 150, 50);
        fix.setBounds(125, 175, 150, 50);
        find.setBounds(125, 250, 150, 50);
        delete.setBounds(125, 325, 150, 50);
        text.setBounds(0, 0, 200, 50);
        adminFrame.add(text);
        adminFrame.add(add);
        adminFrame.add(find);
        adminFrame.add(fix);
        adminFrame.add(delete);
        adminFrame.setLayout(null);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.getContentPane().setBackground(Color.pink);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(false);
    }

    public void setAdminFrame(boolean x) {
        adminFrame.setVisible(x);
    }

    public void listenActionAdmin(QuestionManagerInterface questionAdmin) {
        add.addActionListener((ActionEvent e) -> {
            questionAdmin.setQuestionFrame(true);
            questionAdmin.setFeature("add");
        });
        find.addActionListener((ActionEvent e) -> {
            questionAdmin.setQuestionFrame(true);
            questionAdmin.setFeature("find");
        });
        fix.addActionListener((ActionEvent e) -> {
            questionAdmin.setQuestionFrame(true);
            questionAdmin.setFeature("fix");
        });
        delete.addActionListener((ActionEvent e) -> {
            questionAdmin.setQuestionFrame(true);
            questionAdmin.setFeature("delete");
        });
    }
}
