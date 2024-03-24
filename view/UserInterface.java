package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author FPT
 */
public class UserInterface {

    private JFrame userFrame = new JFrame("ProPuzzle");
    private JList typesList = new JList();
    private JLabel typesText = new JLabel("Chọn chủ đề: ");
    private JTextField numberQuestion = new JTextField("số lượng câu hỏi");
    private JButton start = new JButton("Start");

    public UserInterface() {
        userFrame.setSize(400, 500);
        userFrame.setLayout(new FlowLayout());
        userFrame.setVisible(true);
        String[] data = {"topic 1", "topic 2"};
        typesList = new JList<>(data);
        userFrame.add(typesText);
        userFrame.add(typesList);
        userFrame.add(numberQuestion);
        userFrame.add(start);
        listenAction();
    }

    public void listenAction() {
        start.addActionListener((ActionEvent e) -> {
            // gọi hàm xử lí lấy danh sách câu hỏi           

            QuestionInterface questionInterface = new QuestionInterface();
        });
    }

    public Integer getNumbeQuestion() {
        try {
            return Integer.parseInt(numberQuestion.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
