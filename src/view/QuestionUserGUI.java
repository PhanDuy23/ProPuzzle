package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import model.Question;

/**
 *
 * @author FPT
 */
public class QuestionUserGUI {

    private final JFrame questionFrame = new JFrame("ProPuzzle");
    private final JButton beforeButton = new JButton("quay lại");
    private final JButton sendButton = new JButton("tiếp theo");
    private JLabel question = new JLabel("Question");
    private JScrollPane scrollQuestion = new JScrollPane(question); // cuộn câu hỏi
    private JLabel comment = new JLabel();
    private JLabel idtext = new JLabel("Id");
    private JRadioButton a = new JRadioButton("A");
    private JRadioButton b = new JRadioButton("B");
    private JRadioButton c = new JRadioButton("C");
    private JRadioButton d = new JRadioButton("D");
    private ButtonGroup answerGroup = new ButtonGroup();
    private int userAnswer = 0;
    Integer id = 1;

    public QuestionUserGUI() {
        questionFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        questionFrame.setLayout(null);
        questionFrame.setLocationRelativeTo(null);
        addComponent();
        setBackground();
        setFontComponent();
        setBoundsComponent();
        resetColerAnswer();
//        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setQuestion(Question q, Integer number) {
        question.setText(q.getQuestion());
        idtext.setText("Câu hỏi " + number.toString() + ": ");
        a.setText(q.getA());
        b.setText(q.getB());
        c.setText(q.getC());
        d.setText(q.getD());
    }

    public Integer getUserAnswer() {
        return userAnswer;
    }

    public void removeButton() {
        questionFrame.remove(beforeButton);
        questionFrame.remove(sendButton);
    }

    public void setComment(String s) {
        comment.setText(s);
    }

    public void setAnswerRadioButton(int x) {
        if (x == 1) {
            a.isSelected();
        } else if (x == 2) {
            b.isSelected();
        } else if (x == 3) {
            c.isSelected();
        } else if (x == 4) {
            d.isSelected();
        }
    }

    public void addComponent() {
        questionFrame.add(idtext);
        questionFrame.add(scrollQuestion);
        questionFrame.add(a);
        questionFrame.add(b);
        questionFrame.add(c);
        questionFrame.add(d);
        questionFrame.add(beforeButton);
        questionFrame.add(sendButton);
        questionFrame.add(comment);
        answerGroup.add(a);
        answerGroup.add(b);
        answerGroup.add(c);
        answerGroup.add(d);
    }

    public Font setFont() {
        Font x = new Font("Arial", Font.BOLD, 30);
        return x;
    }

    public void setFontComponent() {
        idtext.setFont(setFont());
        question.setFont(setFont());
        a.setFont(setFont());
        b.setFont(setFont());
        c.setFont(setFont());
        d.setFont(setFont());
        beforeButton.setFont(setFont());
        sendButton.setFont(setFont());
        beforeButton.setForeground(Color.WHITE);
        sendButton.setForeground(Color.WHITE);
        comment.setFont(setFont());
    }

    public void setBoundsComponent() {
        idtext.setBounds(660, 120, 200, 40);
        scrollQuestion.setBounds(820, 120, 550, 80);
        a.setBounds(750, 200, 500, 50);
        b.setBounds(750, 275, 500, 50);
        c.setBounds(750, 350, 500, 50);
        d.setBounds(750, 425, 500, 50);
        beforeButton.setBounds(675, 570, 200, 50);
        sendButton.setBounds(1225, 570, 200, 50);
        comment.setBounds(960, 500, 300, 50);
        scrollQuestion.getViewport().setBackground(Color.WHITE);
        scrollQuestion.setBorder(null); // ẩn viền

        beforeButton.setBackground(new Color(139, 69, 19));
        sendButton.setBackground(new Color(139, 69, 19));
    }

    public void resetColerAnswer() {
        a.setBackground(Color.WHITE);
        b.setBackground(Color.WHITE);
        c.setBackground(Color.WHITE);
        d.setBackground(Color.WHITE);
    }

    public void setBackground() {
        ImageIcon background = new ImageIcon("picture/userbackground.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(1536, 800);  // 1536 864
        questionFrame.add(backgroundLabel);
    }

    public void setColorRightQuestion(int x) {
        if (x == 1) {
            a.setBackground(Color.GREEN);
        } else if (x == 2) {
            b.setBackground(Color.GREEN);
        } else if (x == 3) {
            c.setBackground(Color.GREEN);
        } else if (x == 4) {
            d.setBackground(Color.GREEN);
        }
    }

    public void setColorWrongQuestion(int x) {
        if (x == 1) {
            a.setBackground(Color.RED);
        } else if (x == 2) {
            b.setBackground(Color.RED);
        } else if (x == 3) {
            c.setBackground(Color.RED);
        } else if (x == 4) {
            d.setBackground(Color.RED);
        }
    }

    public JButton getBeforeButton() {
        return beforeButton;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public Integer getId() {
        return id;
    }

    public JFrame getQuestionFrame() {
        return questionFrame;
    }

    public ButtonGroup getAnswerGroup() {
        return answerGroup;
    }

    public JRadioButton getA() {
        return a;
    }

    public JRadioButton getB() {
        return b;
    }

    public JRadioButton getC() {
        return c;
    }

    public JRadioButton getD() {
        return d;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public JLabel getComment() {
        return comment;
    }

}
