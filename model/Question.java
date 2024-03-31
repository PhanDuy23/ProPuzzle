package model;

/**
 *
 * @author FPT
 */
public class Question {
    private String id = new String("id");
    private String question = new String("question");
    private String a = new String("a");
    private String b = new String("b");
    private String c = new String("c");
    private String d = new String("d");
    
    public Question(String id, String question, String a, String b, String c, String d   ){
        this.id = id;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public String getAllQuestion(){
        String cut = "</>";
        return id + cut + question + cut + a + cut + b + cut + c + cut + d; 
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }
    
    public String getD() {
        return d;
    }
    public String getQuestion() {
        return question;
    }   
    
    public String getId() {
        return id;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setD(String d) {
        this.d = d;
    }
    
}
