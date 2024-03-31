package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author FPT
 */
public class ResultInterface {

    private final JFrame resultFrame = new JFrame("ProPuzzle");
    private final JButton reviewButton = new JButton("review");
    private JTextField reviewNumberQuestion = new JTextField("nhập câu hỏi mà bạn muốn xem lại");
    private JLabel result = new JLabel("Result");

    public ResultInterface() {
        resultFrame.setSize(400, 500);
        resultFrame.setVisible(false);
        resultFrame.add(result);
        resultFrame.add(reviewNumberQuestion);
        resultFrame.add(reviewButton);
        resultFrame.setLayout(new GridLayout(3, 1, 25,25));
        resultFrame.setLocationRelativeTo(null);
 //       resultFrame.getContentPane().setBackground(Color.pink);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setResultFrame(boolean x) {
        resultFrame.setVisible(x);
    }

    public void setResult(Integer numberAnswerRight, Integer numberQuestion) {
        String s = "Kết quả: đúng " + String.valueOf(numberAnswerRight) + "/" + String.valueOf(numberQuestion) + " câu";
        result.setText(s);
        System.out.println("result = " + s);
    }

    public void listenActionReview() {
        reviewButton.addActionListener((ActionEvent e) -> {
            Integer number = getReviewNumberQuestion();
            if (number > 0) {
                System.out.println("hiển thị câu hỏi số " + number);
            } else {
                JOptionPane.showMessageDialog(resultFrame, "mã câu k hợp lệ");
            }
        });
    }

    public Integer getReviewNumberQuestion() {
        try {
            return Integer.valueOf(reviewNumberQuestion.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
