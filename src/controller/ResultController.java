package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.HandleQuestion;
import model.SoundEffects;
import view.*;

public class ResultController {

    ResultGUI resGUI;
    QuestionUserGUI quesGUI;
    HandleQuestion handleQues;

    public ResultController(QuestionUserGUI quesGUI, ResultGUI resGUI, HandleQuestion handleQues) {
        this.resGUI = resGUI;
        this.quesGUI = quesGUI;
        this.handleQues = handleQues;
        resGUI.getReview().addActionListener(this::handleClickReview);
    }
    
    public void handleClickReview(ActionEvent e) {
        Integer number = getReviewNumberQuestion();
        if (number > 0 && number <= handleQues.getListQuestion().size()) {
            try {
                showReviewQuestion(number - 1);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ResultGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ResultGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ResultGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "mã câu k hợp lệ");
        }
    }

    public Integer getReviewNumberQuestion() {
        try {
            return Integer.valueOf(resGUI.getIdQuestion().getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void showReviewQuestion(int number) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        int answerRight = handleQues.getListAnswerRight().get(number);
        int answerUser = handleQues.getListAnswerUser().get(number);
        quesGUI.resetColerAnswer();
        quesGUI.setQuestion(handleQues.getListQuestion().get(number), number + 1);
        quesGUI.removeButton();
        quesGUI.getQuestionFrame().setVisible(true);
        quesGUI.setAnswerRadioButton(answerRight);
        quesGUI.setColorRightQuestion(answerRight);
        quesGUI.getQuestionFrame().remove(quesGUI.getComment());
        if (answerRight == answerUser) {
            SoundEffects.playSuccessSound();         
        } else if (answerUser == 0) {
            SoundEffects.playviolinloseSound();
            JOptionPane.showMessageDialog(null, "bỏ trống");
        } else {
            SoundEffects.playJeerSound();
            quesGUI.setColorWrongQuestion(answerUser);          
        }
    }
    public void setReviewButtonQuestion() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 25, 25));
        for (int i = 1; i <= handleQues.getNumberQuestion(); i++) {
            JButton reviewButtom  = new JButton(i + "");
            reviewButtom.setBackground(Color.PINK);
            reviewButtom.setSize(100, 100);
            panel.add(reviewButtom);
            reviewButtom.addActionListener(e -> {
                try {
                    this.handleClickReviewButton(e);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        resGUI.getResultFrame().add(panel);
        panel.setOpaque(false);
        panel.setBounds(660, 150, 745, 570);
    }
   public void handleClickReviewButton(ActionEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SoundEffects.playClickButtonSound();
        JButton button = (JButton) e.getSource();
        Integer number = Integer.valueOf(button.getText());
        try {
            showReviewQuestion(number - 1);      
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
