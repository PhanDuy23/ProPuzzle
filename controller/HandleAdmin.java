package controller;

/**
 *
 * @author FPT
 */
public class HandleAdmin {

    private String password = new String("admin");

    public void addQuestion(Question q) {
        // lưu s vào file
        System.out.println("add" + q.getQuestion());
    }

    public void fixQuestion(Question q) {
        System.out.println("fix" + q.getQuestion());
    }

    public void deleteQuestion(Question q) {
        System.out.println("delete" + q.getQuestion());
    }

    public Boolean checkPassword(String s) {
        return (password.equals(s));
    }
}
