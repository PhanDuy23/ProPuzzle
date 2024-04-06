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
import javax.swing.JPanel;
import model.HandleQuestion;
import model.SoundEffects;
import view.*;

public class QuestionUserController {

    HandleQuestion handleQues;
    QuestionUserGUI quesGUI;
    ResultGUI resGUI;
    ResultController resC;

    public QuestionUserController(ResultController resC, ResultGUI resGUI, HandleQuestion handleQues, QuestionUserGUI quesGUI) {
        this.handleQues = handleQues;
        this.quesGUI = quesGUI;
        this.resGUI = resGUI;
        this.resC = resC;
        listenRadioButtons();
        quesGUI.getBeforeButton().addActionListener(e -> {
            try {
                this.handleClickBeforeButton(e);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(QuestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(QuestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        quesGUI.getSendButton().addActionListener(e -> {
            try {
                this.handleClickSendButton(e);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(QuestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(QuestionUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void handleClickSendButton(ActionEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SoundEffects.playClickButtonSound();
        int id = quesGUI.getId();
        handleQues.setAnswerUser(id - 1, quesGUI.getUserAnswer());
        quesGUI.setUserAnswer(0);
        quesGUI.getAnswerGroup().clearSelection();
        quesGUI.setId(id + 1);
        id++;
        if (id <= handleQues.getNumberQuestion()) {
            quesGUI.setQuestion(handleQues.getListQuestion().get(id - 1), id);
        } else {
            showResult();
        }
    }

    public void handleClickBeforeButton(ActionEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SoundEffects.playClickButtonSound();
        int id = quesGUI.getId();
        if (id >= 2) {
            id--;
            quesGUI.setId(id);
            quesGUI.setQuestion(handleQues.getListQuestion().get(id - 1), id);
            System.out.println("tính năng quay lại chưa lưu được đáp án trước đó");
        }
    }

    public void showResult() {
        resGUI.setResult(handleQues.getNumberAnswerRight(), handleQues.getNumberQuestion());
        resGUI.setNumberQuestion(handleQues.getNumberQuestion());
        resC.setReviewButtonQuestion();
        resGUI.getResultFrame().setVisible(true);
        quesGUI.getQuestionFrame().setVisible(false);
    }

    public void listenRadioButtons() {
        quesGUI.getA().addActionListener(this::actionPerformed);
        quesGUI.getB().addActionListener(this::actionPerformed);
        quesGUI.getC().addActionListener(this::actionPerformed);
        quesGUI.getD().addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        if (quesGUI.getA().isSelected() == true) {
            quesGUI.setUserAnswer(1);
        } else if (quesGUI.getB().isSelected()) {
            quesGUI.setUserAnswer(2);
        } else if (quesGUI.getC().isSelected()) {
            quesGUI.setUserAnswer(3);
        } else if (quesGUI.getD().isSelected()) {
            quesGUI.setUserAnswer(4);
        }
    }
    
}
