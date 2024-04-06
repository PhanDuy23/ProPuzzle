package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.HandleFile;
import model.Question;
import view.InputAdminGUI;
import view.QuestionAdminGUI;

public class InputAdminController {

    InputAdminGUI inputAdminGUI;
    Question ques;

    public InputAdminController(InputAdminGUI inputAdminGUI) {
        this.inputAdminGUI = inputAdminGUI;
        listenActionSave();
    }

    public void listenActionSave() {
        inputAdminGUI.getSave().addActionListener((ActionEvent e) -> {
            ques = new Question(inputAdminGUI.getId2().getText(), inputAdminGUI.getQuestion2().getText(),
                           inputAdminGUI.getAnswerRight2().getText(), inputAdminGUI.getB2().getText(),
                           inputAdminGUI.getC2().getText(), inputAdminGUI.getD2().getText());
            inputAdminGUI.resetTextQuestion();
            if (!"".equals(ques.getId())) {
                HandleFile x;
                try {
                    x = new HandleFile();
                    if ("add".equals(inputAdminGUI.getFeature())) {
                        x.saveData(ques.getAllQuestion());
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } else if ("fix".equals(inputAdminGUI.getFeature())) {
                        x.deleteByKeyword(ques.getId());
                        x.saveData(ques.getAllQuestion());
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    } else if ("find".equals(inputAdminGUI.getFeature())) {
                        List<String> list = x.findDataByKeyword(ques.getId());
                        new QuestionAdminGUI(list);
                    } else if ("delete".equals(inputAdminGUI.getFeature())) {
                        x.deleteByKeyword(ques.getId());
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    } else {
                        System.out.println("feature chưa được cập nhật");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InputAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "ID rỗng");
            }
            inputAdminGUI.getQuestionFrame().setVisible(false);
        });
    }
}
