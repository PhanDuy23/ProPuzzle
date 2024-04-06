package view;

import model.*;
import controller.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author FPT
 */
public class InputAdminGUI {

    private JFrame questionFrame = new JFrame("ProPuzzle");
    private JButton save = new JButton("save");
    private JLabel id = new JLabel("ID");
    private JLabel question = new JLabel("Question");
    private JLabel answerRight = new JLabel("AnswerRight");
    private JLabel b = new JLabel("Answer");
    private JLabel c = new JLabel("Answer");
    private JLabel d = new JLabel("Answer");

    private JTextField id2 = new JTextField();
    private JTextField question2 = new JTextField();
    private JTextField answerRight2 = new JTextField();
    private JTextField b2 = new JTextField();
    private JTextField c2 = new JTextField();
    private JTextField d2 = new JTextField();
    private Question ques = new Question("", "", "", "", "", "");
    private String feature = new String("feature");

    public InputAdminGUI() {
        questionFrame.setSize(400, 500);
        questionFrame.setLayout(new BoxLayout(questionFrame.getContentPane(), BoxLayout.Y_AXIS));
        addComponent();
        questionFrame.setLocationRelativeTo(null);
        questionFrame.setVisible(false);
    }

    

    public Question getQuestion() {
        return ques;
    }

    public void setFeature(String s) {
        feature = s;
    }

    public JFrame getQuestionFrame() {
        return questionFrame;
    }

    public String getFeature() {
        return feature;
    }

    public JButton getSave() {
        return save;
    }

    public JTextField getQuestion2() {
        return question2;
    }
    
    public JTextField getAnswerRight2() {
        return answerRight2;
    }
    
    public JTextField getB2() {
        return b2;
    }

    public JTextField getC2() {
        return c2;
    }

    public JTextField getD2() {
        return d2;
    }

    public JTextField getId2() {
        return id2;
    }

    
  
    public void resetTextQuestion() {
        id2.setText("");
        question2.setText("");
        answerRight2.setText("");
        b2.setText("");
        c2.setText("");
        d2.setText("");
    }

    public void addComponent() {
        questionFrame.add(id);
        questionFrame.add(id2);
        questionFrame.add(question);
        questionFrame.add(question2);
        questionFrame.add(answerRight);
        questionFrame.add(answerRight2);
        questionFrame.add(b);
        questionFrame.add(b2);
        questionFrame.add(c);
        questionFrame.add(c2);
        questionFrame.add(d);
        questionFrame.add(d2);
        questionFrame.add(save);
    }
}
