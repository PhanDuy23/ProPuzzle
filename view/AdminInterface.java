package view;

import controller.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminInterface {

    private JFrame adminFrame = new JFrame("ProPuzzle");
    private JButton add = new JButton("add");
    private JButton fix = new JButton("fix");
    private JButton delete = new JButton("delete");

    public AdminInterface() {
        adminFrame.setSize(400, 500);
        adminFrame.add(add);
        adminFrame.add(fix);
        adminFrame.add(delete);
        adminFrame.setLayout(new FlowLayout());
        adminFrame.setVisible(true);
        listenAction();
    }

    public void listenAction() {
        add.addActionListener((ActionEvent e) -> {
            //adminFrame.setVisible(false);
            QuestionManagerInterface x = new QuestionManagerInterface();
            x.setFeature("add");
        });
        fix.addActionListener((ActionEvent e) -> {
            //adminFrame.setVisible(false);
            QuestionManagerInterface x = new QuestionManagerInterface();
            x.setFeature("fix");
        });
        delete.addActionListener((ActionEvent e) -> {
            //adminFrame.setVisible(false);
            QuestionManagerInterface x = new QuestionManagerInterface();
            x.setFeature("delete");
        });
    }
}
