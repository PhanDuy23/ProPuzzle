package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import model.*;
import view.AdminGUI;
import view.InputAdminGUI;

public class AdminController {

    private static final String password = new String("admin");
    AdminGUI adminGUI;
    InputAdminGUI inputAdmin;

    public AdminController(AdminGUI adminGUI, InputAdminGUI inputAdmin) {
        this.adminGUI = adminGUI;
        this.inputAdmin = inputAdmin;
        listenActionAdmin();
    }

    public void listenActionAdmin() {
        adminGUI.getAdd().addActionListener((ActionEvent e) -> {
            inputAdmin.getQuestionFrame().setVisible(true);
            inputAdmin.setFeature("add");
        });
        adminGUI.getFind().addActionListener((ActionEvent e) -> {
            inputAdmin.getQuestionFrame().setVisible(true);
            inputAdmin.setFeature("find");
        });
        adminGUI.getFix().addActionListener((ActionEvent e) -> {
            inputAdmin.getQuestionFrame().setVisible(true);
            inputAdmin.setFeature("fix");
        });
        adminGUI.getDelete().addActionListener((ActionEvent e) -> {
            inputAdmin.getQuestionFrame().setVisible(true);
            inputAdmin.setFeature("delete");
        });
    }

    public List<String> findQuestion(Question q) throws IOException {
        HandleFile x = new HandleFile();
        List<String> list = x.findDataByKeyword(q.getId());
        return list;
    }

    public void deleteQuestion(Question q) throws IOException {
        HandleFile x = new HandleFile();
        x.deleteByKeyword(q.getId());
    }

    public static Boolean checkPassword(String s) {
        return (password.equals(s));
    }
}
