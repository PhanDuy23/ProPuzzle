package view;

import controller.*;
import java.awt.event.ActionEvent;
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
    
    private JLabel id = new JLabel("id");
    private JLabel question = new JLabel("question");
    private JLabel answerRight = new JLabel("answerRight");
    private JLabel b = new JLabel("answer1");
    private JLabel c = new JLabel("answer2");
    private JLabel d = new JLabel("answer3");
    
    private JTextField id2 = new JTextField();
    private JTextField question2 = new JTextField();
    private JTextField answerRight2 = new JTextField();
    private JTextField b2 = new JTextField();
    private JTextField c2 = new JTextField();
    private JTextField d2 = new JTextField();
    private Question ques = new Question("","","","","","");
    private String feature  = new String("feature");
    public QuestionManagerInterface(){
        questionFrame.setSize(400, 500);
        questionFrame.setLayout(new BoxLayout(questionFrame.getContentPane(), BoxLayout.Y_AXIS));
        questionFrame.setVisible(true);
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
        listenAction();    
    }
    public void listenAction() {
        save.addActionListener((ActionEvent e) -> {
            ques = new Question(id2.getText(),question2.getText(),
                           answerRight2.getText(),b2.getText(),
                           c2.getText(), d2.getText());
            HandleAdmin x = new HandleAdmin();
            if(feature == "add") {
                
                x.addQuestion(ques);
            }else if(feature == "fix"){
                
                x.fixQuestion(ques);
            }else if(feature == "delete"){
                
                x.deleteQuestion(ques);
            }else{
                System.out.println("save.addActionListener().listenAction().QuestionManagerInterface");
            }           
        });
    }
    public Question getQuestion(){
        return ques;
    }
    public void setFeature(String s){
        feature = s;
    }
}
