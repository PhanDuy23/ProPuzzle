package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.HandleQuestion;
import view.*;

public class Main {

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            InitialGUI initGUI = new InitialGUI();
            AdminGUI adminGUI = new AdminGUI();
            UserGUI userGUI = new UserGUI();
            QuestionUserGUI quesUserGUI = new QuestionUserGUI();
            ResultGUI resGUI = new ResultGUI();
            InputAdminGUI inputAdminGUI = new InputAdminGUI();

            InitialController initC = new InitialController(initGUI, adminGUI, userGUI);

            AdminController adminC = new AdminController(adminGUI, inputAdminGUI);

            InputAdminController inputAdminC = new InputAdminController(inputAdminGUI);

            HandleQuestion handleQues;
            try {
                handleQues = new HandleQuestion();
                ResultController resC = new ResultController(quesUserGUI, resGUI, handleQues);
                QuestionUserController quesUserC = new QuestionUserController(resC, resGUI, handleQues, quesUserGUI);
                    
                UserController userC = new UserController(quesUserC, userGUI, quesUserGUI, handleQues);
           
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
