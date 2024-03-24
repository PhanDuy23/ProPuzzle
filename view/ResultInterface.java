package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author FPT
 */
public class ResultInterface {

    private JFrame resultFrame = new JFrame("ProPuzzle");
    private JButton reviewButton = new JButton("review");
    private JTextField reviewnumberQuestion = new JTextField("nhập câu hỏi mà bạn muốn xem lại");
    private JLabel result = new JLabel("result");
    private int numberQuestionRight = 0;

    public ResultInterface() {
        resultFrame.setSize(400, 500);
        resultFrame.setLayout(new FlowLayout());
        resultFrame.setVisible(true);
        resultFrame.add(result);
        resultFrame.add(reviewnumberQuestion);
        resultFrame.add(reviewButton);
        setNumberQuestionRight();
        result.setText("số câu trả lời đúng" + String.valueOf(numberQuestionRight) + "\n");
        listenAction();
    }

    public void setNumberQuestionRight() {
        numberQuestionRight = 1;
    }

    public void listenAction() {
        reviewButton.addActionListener((ActionEvent e) -> {
            // gọi hàm xử lí lấy danh sách câu hỏi
            System.out.println(reviewnumberQuestion.getText());

        });
    }
}
