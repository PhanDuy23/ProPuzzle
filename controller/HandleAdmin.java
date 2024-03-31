package controller;

import java.io.IOException;
import java.util.List;
import model.*;
/**
 *
 * @author FPT
 */
public class HandleAdmin {

    private final String password = new String("admin");

    public void addQuestion(Question q) throws IOException {       
        HandleFile x = new HandleFile();
        x.saveData(q.getAllQuestion());
    }
    public List<String> findQuestion(Question q) throws IOException {       
        HandleFile x = new HandleFile();
        List<String> list =  x.findDataByKeyword(q.getId());
        return list;
    }

    public void fixQuestion(Question q) throws IOException {
        deleteQuestion(q);
        addQuestion(q);
    }

    public void deleteQuestion(Question q) throws IOException {
        HandleFile x = new HandleFile();
        x.deleteByKeyword(q.getId());
    }

    public Boolean checkPassword(String s) {
        return (password.equals(s));
    }
}
