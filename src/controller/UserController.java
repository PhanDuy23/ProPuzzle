package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import model.*;
import view.*;

public class UserController {

    UserGUI userGUI;
    HandleQuestion handleQues;
    QuestionUserGUI quesGUI;
    QuestionUserController quesUserC;

    public UserController(QuestionUserController quesUserC, UserGUI userGUI, QuestionUserGUI quesGUI, HandleQuestion handleQues) throws IOException {
        this.userGUI = userGUI;
        this.handleQues = handleQues;
        this.quesGUI = quesGUI;
        this.quesUserC = quesUserC;
        setMaxQuestionText();
        userGUI.getStart().addActionListener(e -> {
            try {
                this.handleClickStart(e);
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        userGUI.getSound().addActionListener(e -> {
            try {
                this.handleClickSound(e);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        userGUI.getEasy().addActionListener(e -> {
            try {
                this.handleClickEasy(e);
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        userGUI.getMedium().addActionListener(e -> {
            try {
                this.handleClickMedium(e);
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        userGUI.getDifficult().addActionListener(e -> {
            try {
                this.handleClickDifficult(e);
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public void handleClickStart(ActionEvent e) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        int number = getNumberQuestion();
        setLevel(number, 60);
    }

    public void handleClickSound(ActionEvent e) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        SoundEffects.playBackgroundSound();        
    }

    public void handleClickEasy(ActionEvent e) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        setLevel(10, 60);
    }

    public void handleClickMedium(ActionEvent e) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        setLevel(15, 55);
    }

    public void handleClickDifficult(ActionEvent e) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        setLevel(20, 50);
    }

    public void setLevel(int number, int time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        SoundEffects.playClickButtonSound();
        if (number > 0) {
            handleQues.setHandleQuestion(number);
            Countdown countdown = new Countdown(quesUserC);
            countdown.startCountdown(quesGUI.getComment(), time);
            quesGUI.setQuestion(handleQues.getListQuestion().get(0), 1);
            quesGUI.getQuestionFrame().setVisible(true);
            userGUI.getUserFrame().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "số câu hỏi không hợp lệ");
        }
    }

    public Integer getNumberQuestion() {
        try {
            return Integer.valueOf(userGUI.getNumberQuestion().getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setMaxQuestionText() throws IOException {
        HandleFile x = new HandleFile();
        userGUI.setTextMaxQuestion("Max: " + x.getSizeRow().toString());
    }

}
