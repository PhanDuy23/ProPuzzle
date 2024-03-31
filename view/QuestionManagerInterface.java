package view;

import model.*;
import controller.*;
import java.awt.Color;
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
import javax.swing.JTextField;

/**
 *
 * @author FPT
 */
public class QuestionManagerInterface {

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

    public QuestionManagerInterface() {
        questionFrame.setSize(400, 500);
        questionFrame.setLayout(new BoxLayout(questionFrame.getContentPane(), BoxLayout.Y_AXIS));
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
        questionFrame.setLocationRelativeTo(null);
        questionFrame.getContentPane().setBackground(Color.pink);
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.setVisible(false);
    }

    public void listenActionSave() {
        save.addActionListener((ActionEvent e) -> {
            ques = new Question(id2.getText(), question2.getText(),
                           answerRight2.getText(), b2.getText(),
                           c2.getText(), d2.getText());
            resetTextQuestion();
            HandleAdmin handleAdmin = new HandleAdmin();
            if ("add".equals(feature)) {
                try {
                    handleAdmin.addQuestion(ques);
                } catch (IOException ex) {
                    Logger.getLogger(QuestionManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("fix".equals(feature)) {
                try {
                    handleAdmin.fixQuestion(ques);
                } catch (IOException ex) {
                    Logger.getLogger(QuestionManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("find".equals(feature)) {
                List<String> list = new ArrayList<>();
                try {
                    list = handleAdmin.findQuestion(ques);             
                    new ShowQuestionAdmin(list);
                } catch (IOException ex) {
                    Logger.getLogger(QuestionManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("delete".equals(feature)) {
                try {
                    handleAdmin.deleteQuestion(ques);
                } catch (IOException ex) {
                    Logger.getLogger(QuestionManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("feature chưa được cập nhật");
            }
            questionFrame.setVisible(false);
        });
    }

    public Question getQuestion() {
        return ques;
    }

    public void setFeature(String s) {
        feature = s;
    }

    public void setQuestionFrame(boolean x) {
        questionFrame.setVisible(x);
    }
    public void resetTextQuestion(){
        id2.setText(""); question2.setText(""); answerRight2.setText("");
        b2.setText(""); c2.setText(""); d2.setText("");
    }
}
