package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class HandleQuestion {

    private Integer numberQuestion, maxQuestion;
    private List<Question> listQuestion = new ArrayList<>();
    private List<Integer> listAnswerRanDom = new ArrayList<>();
    private List<Integer> listAnswerRight = new ArrayList<>();
    private List<Integer> listAnswerUser;
    private Boolean[] mark;

    public HandleQuestion() throws IOException {
        setMaxQuestion();
    }

    public void setHandleQuestion(Integer x) throws IOException {
        setNumberQuestion(x);
        mark = new Boolean[maxQuestion + 5];
        for (int i = 0; i < maxQuestion + 5; i++) {
            mark[i] = false;
        }
        setListAnswerRanDom();
        setListQuestion();
        listAnswerRight = new ArrayList<>(maxQuestion + 5);
        setListAnswerRight();
        listAnswerUser = new ArrayList<>(maxQuestion + 5);
        for (int i = 0; i < maxQuestion + 5; i++) {
            listAnswerUser.add(0);
        }

    }

    public void setNumberQuestion(Integer x) {
        if (x > maxQuestion) {
            numberQuestion = maxQuestion;
        } else {
            numberQuestion = x;
        }
    }

    public void setMaxQuestion() throws IOException {
        HandleFile x = new HandleFile();
        maxQuestion = x.getSizeRow();
    }

    public void setListAnswerRanDom() {
        for (int i = 1; i <= numberQuestion; i++) {
            int x;
            while (1 > 0) {
                x = random(maxQuestion);
                if (mark[x] == false) {
                    mark[x] = true;
                    break;
                }
            }
            listAnswerRanDom.add(x);
        }
        Collections.sort(listAnswerRanDom);
    }

    public void setListQuestion() throws IOException {
        HandleFile x = new HandleFile();
        if (!listAnswerRanDom.isEmpty()) {
            List<String> listQuestionString = x.findDataByRow(listAnswerRanDom);
            for (String s : listQuestionString) {
                listQuestion.add(transferIntoQuestion(s));
            }
        } else {
            System.out.println("list answer random trống");
        }

    }

    public void setAnswerUser(int id, int answer) {
        listAnswerUser.set(id, answer);
    }

    public void setListAnswerRight() {
        for (int i = 0; i < listQuestion.size(); i++) {
            int x = random(4);
            listAnswerRight.add(x);
            String s;
            if (x == 2) {
                s = listQuestion.get(i).getB();
                listQuestion.get(i).setB(listQuestion.get(i).getA());
                listQuestion.get(i).setA(s);
            } else if (x == 3) {
                s = listQuestion.get(i).getC();
                listQuestion.get(i).setC(listQuestion.get(i).getA());
                listQuestion.get(i).setA(s);
            } else if (x == 4) {
                s = listQuestion.get(i).getD();
                listQuestion.get(i).setD(listQuestion.get(i).getA());
                listQuestion.get(i).setA(s);
            }
        }
    }

    public Integer getNumberAnswerRight() {
        int cnt = 0;
        for (int i = 0; i < listAnswerRight.size(); i++) {
            if (Objects.equals(listAnswerRight.get(i), listAnswerUser.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public List<Integer> getListAnswerRight() {
        return listAnswerRight;
    }

    public List<Integer> getListAnswerUser() {
        return listAnswerUser;
    }

    public Integer getNumberQuestion() {
        return numberQuestion;
    }

    public Question transferIntoQuestion(String line) {
        String x[] = line.split("</>");
        Question ques = new Question(x[0], x[1], x[2], x[3], x[4], x[5]);
        return ques;
    }

    public Integer random(int max) { // 1 --> maxQuestion            
        int x = (int) (Math.random() * max + 1); // min = 1
        return x;
    }
}
