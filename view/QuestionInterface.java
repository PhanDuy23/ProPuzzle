package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import model.HandleQuestion;
import model.Question;

/**
 *
 * @author FPT
 */
public class QuestionInterface {

    private final JFrame questionFrame = new JFrame("ProPuzzle");
    private final JButton beforeButton = new JButton("quay lại");
    private final JButton sendButton = new JButton("tiếp theo");
    private JLabel question = new JLabel("Question");
    private JLabel atext = new JLabel("A");
    private JLabel btext = new JLabel("B");
    private JLabel ctext = new JLabel("C");
    private JLabel dtext = new JLabel("D");
    private JLabel idtext = new JLabel("Id");
    private JRadioButton a = new JRadioButton("A");
    private JRadioButton b = new JRadioButton("B");
    private JRadioButton c = new JRadioButton("C");
    private JRadioButton d = new JRadioButton("D");
    private ButtonGroup answerGroup = new ButtonGroup();
    private int userAnswer = 0;
    Integer id = 1;

    public QuestionInterface() {
        questionFrame.setSize(400, 500);      
        questionFrame.add(idtext);
        questionFrame.add(question);
        questionFrame.add(a);
        questionFrame.add(atext);
        questionFrame.add(b);
        questionFrame.add(btext);
        questionFrame.add(c);
        questionFrame.add(ctext);
        questionFrame.add(d);
        questionFrame.add(dtext);
        questionFrame.add(beforeButton);
        questionFrame.add(sendButton);
        answerGroup.add(a);
        answerGroup.add(b);
        answerGroup.add(c);
        answerGroup.add(d);
        questionFrame.setLayout(new GridLayout(6, 2, 25,25));
        questionFrame.setLocationRelativeTo(null);
 //       questionFrame.getContentPane().setBackground(Color.pink);
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listenRadioButtons();
    }

    public void setQuestionFrame(boolean x) {
        questionFrame.setVisible(x);
    }

    public void setQuestion(Question q) {
        question.setText(q.getQuestion());
        atext.setText(q.getA());
        btext.setText(q.getB());
        ctext.setText(q.getC());
        dtext.setText(q.getD());
    }

    public void setIdText(String s) {
        idtext.setText("Câu hỏi " + s + ": ");
    }

    public void listenRadioButtons() {
        a.addActionListener(this::actionPerformed);
        b.addActionListener(this::actionPerformed);
        c.addActionListener(this::actionPerformed);
        d.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        if (a.isSelected() == true) {
            userAnswer = 1;
        } else if (b.isSelected()) {
            userAnswer = 2;
        } else if (c.isSelected()) {
            userAnswer = 3;
        } else if (d.isSelected()) {
            userAnswer = 4;
        } else {
            userAnswer = 5;
        }
    }

    public void listenActionSend(HandleQuestion handleQuestion, QuestionInterface quesIn, ResultInterface res) {
        sendButton.addActionListener((ActionEvent e) -> {
            handleQuestion.setAnswerUser(id-1, userAnswer);
            answerGroup.clearSelection();
            id++;
            if (id <= handleQuestion.getNumberQuestion()) {
                quesIn.setIdText(id.toString());
                quesIn.setQuestion(handleQuestion.getListQuestion().get(id - 1));
            } else {
                res.setResult(handleQuestion.getNumberAnswerRight(), handleQuestion.getNumberQuestion());
                res.setResultFrame(true);
                questionFrame.setVisible(false);
            }
        });       
        beforeButton.addActionListener((ActionEvent e) -> {
            if(id >= 2){
                id--;
                quesIn.setIdText(id.toString());
                quesIn.setQuestion(handleQuestion.getListQuestion().get(id - 1));
                System.out.println("tính năng quay lại chưa lưu được đáp án trước đó");
            }              
        });
        
    };
    
    public Integer getUserAnswer() {
        return userAnswer;
    }
}
