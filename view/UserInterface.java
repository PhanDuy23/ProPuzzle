package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.*;

/**
 *
 * @author FPT
 */
public final class UserInterface {

    private final JFrame userFrame = new JFrame("ProPuzzle");
    private JList typesList = new JList();
    private final JLabel typesText = new JLabel("Chọn chủ đề: ");
    private JTextField numberQuestion = new JTextField();
    private final JButton start = new JButton("Start");
    private JLabel maxQuestionText = new JLabel("MAX");
    private JLabel numberQuestionText = new JLabel("Số lượng câu hỏi");

    public UserInterface() throws IOException {
        userFrame.setSize(400, 500);
        userFrame.setLayout(new GridLayout(3, 2, 25,25));      
        String[] data = {"Topic 1", "Topic 2", "Topic 3"};
        typesList = new JList<>(data);
        userFrame.add(typesText);
        userFrame.add(typesList);
        userFrame.add(numberQuestionText);
        userFrame.add(numberQuestion);
        userFrame.add(maxQuestionText);
        userFrame.add(start);
        userFrame.setLocationRelativeTo(null);
//        userFrame.getContentPane().setBackground(Color.pink);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaxQuestionText();
    }

    public void listenActionStart(HandleQuestion handleQuestion, QuestionInterface quesIn) {
        start.addActionListener((ActionEvent e) -> {
            int number = getNumberQuestion();
            if (number > 0) {
                try {
                    handleQuestion.setHandleQuestion(number);
                    quesIn.setIdText("1");
                    quesIn.setQuestion(handleQuestion.getListQuestion().get(0));
                    quesIn.setQuestionFrame(true);
                    userFrame.setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(userFrame, "số câu hỏi không hợp lệ");
            }
        });
    }

    public Integer getNumberQuestion() {
        try {
            return Integer.valueOf(numberQuestion.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setUserFrame(boolean x) {
        userFrame.setVisible(x);
    }

    public void setMaxQuestionText() throws IOException {
        HandleFile x = new HandleFile();
        maxQuestionText.setText("Max: " + x.getSizeRow().toString());
    }
    
}
