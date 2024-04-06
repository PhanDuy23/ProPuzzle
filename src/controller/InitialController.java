package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import model.SoundEffects;
import view.*;

public class InitialController {

    InitialGUI initGUI;
    AdminGUI adminGUI;
    UserGUI userGUI;

    public InitialController(InitialGUI initGUI, AdminGUI adminGUI, UserGUI userGUI) {
        this.initGUI = initGUI;
        this.adminGUI = adminGUI;
        this.userGUI = userGUI;
        initGUI.getAdminButton().addActionListener(e -> {
            try {
                this.handleAdminButtonClick(e);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(InitialController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InitialController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(InitialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        initGUI.getUserButton().addActionListener(e -> {
            try {
                this.handleUserButtonClick(e);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(InitialController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InitialController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(InitialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void handleAdminButtonClick(ActionEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SoundEffects.playClickButtonSound();
        initGUI.getPasswordField().setVisible(true);
        if (AdminController.checkPassword(initGUI.getPasswordField().getText())) {
            adminGUI.getAdminFrame().setVisible(true);
//            initGUI.getInitFrame().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "sai mật khẩu");
        }
    }

    private void handleUserButtonClick(ActionEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SoundEffects.playClickButtonSound();
        userGUI.getUserFrame().setVisible(true);
 //       initGUI.getInitFrame().setVisible(false);
    }
}
