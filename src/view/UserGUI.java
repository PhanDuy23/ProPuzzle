package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
/**
 *
 * @author FPT
 */
public final class UserGUI {

    private final JFrame userFrame = new JFrame("ProPuzzle");
    private JList typesList = new JList();
    private final JLabel typesText = new JLabel("Chọn chủ đề: ");
    private final JTextField numberQuestion = new JTextField();
    private final JButton start = new JButton(), easy = new JButton("easy"),
                   medium = new JButton("medium"),
                   difficult = new JButton("difficult"),
                   sound = new JButton();
    private final JLabel maxQuestionText = new JLabel("MAX");
    private final JLabel numberQuestionText = new JLabel("Chọn số lượng câu hỏi:");

    public UserGUI() {
        userFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        userFrame.setLayout(null);
        //setTopic();     
        addComponent();
        setComponent();
        setBackground_Icon();
        userFrame.setLocationRelativeTo(null);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean x) {
        userFrame.setVisible(x);
    }   

    public void setTopic() {
        String[] data = {"hài vui", "hài nhạt"};
        typesList = new JList<>(data);
        userFrame.add(typesText);
        userFrame.add(typesList);
        typesText.setFont(new Font("Arial", Font.BOLD, 30));
        typesList.setFont(new Font("Arial", Font.BOLD, 30));
        typesText.setBounds(700, 10, 300, 100);
        typesList.setBounds(1050, 20, 100, 30);
    }

    public void setBackground_Icon() {
        ImageIcon background = new ImageIcon("picture/userbackground.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(1536, 800);  // 1536 864
        userFrame.add(backgroundLabel);
        ImageIcon startIcon = new ImageIcon("picture/start.png");
        start.setIcon(startIcon);
        ImageIcon soundIcon = new ImageIcon("picture/sound.png");
        sound.setIcon(soundIcon);
    }

    public void addComponent() {
        userFrame.add(sound);
        userFrame.add(numberQuestionText);
        userFrame.add(numberQuestion);
        userFrame.add(maxQuestionText);
        userFrame.add(start);
        userFrame.add(easy);
        userFrame.add(medium);
        userFrame.add(difficult);
    }

    public void setComponent() {
        numberQuestionText.setFont(new Font("Arial", Font.BOLD, 30));
        maxQuestionText.setFont(new Font("Arial", Font.BOLD, 30));
        numberQuestion.setFont(new Font("Arial", Font.BOLD, 30));
        
        numberQuestionText.setBounds(700, 400, 500, 100);
        numberQuestion.setBounds(1050, 440, 100, 30);
        maxQuestionText.setBounds(1300, 400, 200, 100);
        sound.setBounds(1400, 60, 30, 30);
        easy.setBounds(700, 200, 200, 100);
        medium.setBounds(950, 300, 200, 100);
        difficult.setBounds(1200, 200, 200, 100);
        start.setBounds(825, 525, 400, 160);
        
        easy.setBackground(new Color(139, 69, 19));
        medium.setBackground(new Color(139, 69, 19));
        difficult.setBackground(new Color(139, 69, 19));
        
        easy.setForeground(Color.WHITE);
        medium.setForeground(Color.WHITE);
        difficult.setForeground(Color.WHITE);       
        
    }
    public void setTextMaxQuestion(String s){
        maxQuestionText.setText(s);
    }
    public JFrame getUserFrame(){
        return userFrame;
    }

    public JButton getStart() {
        return start;
    }

    public JButton getSound() {
        return sound;
    }

    public JButton getEasy() {
        return easy;
    }

    public JButton getMedium() {
        return medium;
    }

    public JButton getDifficult() {
        return difficult;
    }

    public JTextField getNumberQuestion() {
        return numberQuestion;
    }
    
}
