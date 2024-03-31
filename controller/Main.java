package controller;

import java.io.IOException;
import model.HandleQuestion;
import view.*;

/*
- Có 1 tài khoản admin fix cứng, đăng ký thì là user
- Thêm sửa xoá các bài thi
- Trong bài thi sẽ tạo được các câu hỏi
- User vào làm thi thì câu hỏi bị đảo ngẫu nhiên thứ tự
- Xuất kết quả
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InitialInterface init = new InitialInterface();
        AdminInterface adminInterface = new AdminInterface();
        QuestionManagerInterface quesAdIn = new QuestionManagerInterface();

        UserInterface userInterface = new UserInterface();
        QuestionInterface quesIn = new QuestionInterface();
        HandleQuestion handleQuestion = new HandleQuestion();
        ResultInterface res = new ResultInterface();

        init.setInitialFrame(true);
        init.listenActionInitial(adminInterface, userInterface);
        // if click admin       
        adminInterface.listenActionAdmin(quesAdIn);
        quesAdIn.listenActionSave();
        // if click user       
        userInterface.listenActionStart(handleQuestion, quesIn);

        quesIn.listenActionSend(handleQuestion, quesIn, res);

        res.listenActionReview();

    }
}
