package model;

import controller.QuestionUserController;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown  {
       
    int countdownTime ;
    QuestionUserController quesUserC;
    
    public Countdown(QuestionUserController quesUserC){
        this.quesUserC = quesUserC;
    }
    
    public void startCountdown(JLabel timerLabel, int time ) {
        Timer timer = new Timer();
        this.countdownTime = time;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    if (countdownTime >= 0) {
                        timerLabel.setText("còn "+ countdownTime+" second");
                        countdownTime--;
                    } else {
                        timerLabel.setText("");
                        countdownInto0();
                        timer.cancel();
                    }
                });
            }
        }, 0, 1000); // Đếm ngược mỗi giây (1000 milliseconds)
    }
    
    public void countdownInto0(){
        quesUserC.showResult();
    }
    
}
