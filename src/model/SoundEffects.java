package model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class SoundEffects {

    
    
    public static void playBackgroundSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sounds/background3.wav");
        openFileSound(file);
    }
    public static void stopBackgroundSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sounds/background3.wav");
        stopFileSound(file);
    }

    public static void playClickButtonSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sounds/clickButton.wav");
        openFileSound(file);
    }

    public static void playJeerSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sounds/jeer.wav");
        openFileSound(file);
    }

    public static void playSuccessSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sounds/success.wav");
        openFileSound(file);
    }

    public static void playviolinloseSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("sounds/violinlose.wav");
        openFileSound(file);
    }

    public static void openFileSound(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (file.exists()) {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } else {
            JOptionPane.showMessageDialog(null, "file sound no exists");
        }
    }
    public static void stopFileSound(File file) {
        if (file.exists()) {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);             
                clip.stop();              
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "File sound does not exist");
        }
    }
}
