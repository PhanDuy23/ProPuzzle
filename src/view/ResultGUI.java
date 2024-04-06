package view;

import controller.ResultController;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author FPT
 */
public class ResultGUI {
    private final JFrame resultFrame = new JFrame("ProPuzzle");
    private JLabel result = new JLabel("Result");
    private JLabel reviewButtonText = new JLabel("Nhập câu hỏi: ");
    private final JButton review = new JButton("xem lại");
    private JTextField idQuestion = new JTextField();
    private Integer numberQuestion;

    public ResultGUI() {  
        resultFrame.add(result);
        resultFrame.add(reviewButtonText);
        resultFrame.add(idQuestion);
        resultFrame.add(review);
        setPositionComponent();
        setBackground();
        resultFrame.setLayout(null);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
    
    public void setResult(Integer numberAnswerRight, Integer numberQuestion) {
        String s = "Kết quả: đúng " + String.valueOf(numberAnswerRight) + "/" + String.valueOf(numberQuestion) + " câu";
        result.setText(s);
    }

    

    public void setPositionComponent() {
        result.setBounds(200, 225, 200, 40);
        reviewButtonText.setBounds(150, 300, 100, 40);
        idQuestion.setBounds(250, 310, 100, 30);
        review.setBounds(260, 350, 80, 30);
    }

    public void setNumberQuestion(int x){
        numberQuestion = x;
    }
 /*   public void setReviewButtonQuestion() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 25, 25));
        for (int i = 1; i <= numberQuestion; i++) {
            JButton reviewButtom  = new JButton(i + "");
            reviewButtom.setBackground(Color.PINK);
            reviewButtom.setSize(100, 100);
            panel.add(reviewButtom);
            reviewButtom.addActionListener(this :: handleClickReviewButton);
        }
        resultFrame.add(panel);
        panel.setOpaque(false);
        panel.setBounds(660, 150, 745, 570);
    }*/
    public void handleClickReviewButton(ActionEvent  e){
        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());
    }
   
      

    public void setBackground() {
        ImageIcon background = new ImageIcon("picture/resultbackground.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1530, 860);  // 1536 86    
        resultFrame.add(backgroundLabel);
    }

    public JButton getReview() {
        return review;
    }

    public JFrame getResultFrame() {
        return resultFrame;
    }

    public JTextField getIdQuestion() {
        return idQuestion;
    }
    
}
