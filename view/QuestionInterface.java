package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author FPT
 */
public class QuestionInterface {

    private JFrame questionFrame = new JFrame("ProPuzzle");
    private JButton sendButton = new JButton("send");
    private JLabel question = new JLabel("question");
    private JRadioButton a = new JRadioButton("A");
    private JRadioButton b = new JRadioButton("B");
    private JRadioButton c = new JRadioButton("C");
    private JRadioButton d = new JRadioButton("D");
    private ButtonGroup answerGroup = new ButtonGroup();
    private int userAnswer = 0;

    public QuestionInterface() {
        questionFrame.setSize(400, 500);
        questionFrame.setLayout(new FlowLayout());
        questionFrame.setVisible(true);
        setQuestion();
        questionFrame.add(question);
        questionFrame.add(a);
        questionFrame.add(b);
        questionFrame.add(c);
        questionFrame.add(d);
        questionFrame.add(sendButton);
        answerGroup.add(a);
        answerGroup.add(b);
        answerGroup.add(c);
        answerGroup.add(d);
        listenAction();
    }

    public void setQuestion() {
        question.setText("đề bài: What is the opposite of \"begin\"?"
                       + "A start"
                       + "B end"
                       + "C yes"
                       + "D no");
    }

    public void listenRadioButtons() {
        a.addActionListener(this::actionPerformed);
        b.addActionListener(this::actionPerformed);
        c.addActionListener(this::actionPerformed);
        d.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        if (a.isSelected()) {
            userAnswer = 1;
        }
        if (b.isSelected()) {
            userAnswer = 2;
        }
        if (c.isSelected()) {
            userAnswer = 3;
        }
        if (d.isSelected()) {
            userAnswer = 4;
        }
    }

    public void listenAction() {
        sendButton.addActionListener((ActionEvent e) -> {
            listenRadioButtons();
            // xử lí check đán án
            ResultInterface resultInterface = new ResultInterface();

        }
        );
    }

    ;
    
    public Integer getUserAnswer() {
        return userAnswer;
    }
}
