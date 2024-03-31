package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT
 */
public class HandleFile {

    private Integer sizeRow;

    public HandleFile() throws IOException {      
        sizeRow = setSizeRow();            
    }

    public Integer getSizeRow() {
        return sizeRow;
    }

    public Integer setSizeRow() throws IOException {
        FileReader fr = new FileReader("maxQuestion.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        return Integer.valueOf(line);
    }

    public void saveData(String s) throws IOException {
        sizeRow++;
        try (FileWriter fw = new FileWriter("question.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(s);
            bw.newLine();
        }
        resetSizeRow();// cập nhật số câu hỏi
    }

    public List<String> findDataByRow(List<Integer> numberRow) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("question.txt");
        BufferedReader br = new BufferedReader(fr);
        List list = new ArrayList<String>();
        String line;
        boolean[] marked = new boolean[sizeRow + 5];
        for (int x : numberRow) {
            marked[x] = true;
        }
        int i = 0;
        int sizeList = numberRow.size();
        while (sizeList > 0) {
            i++;
            line = br.readLine();
            if (line == null) {
                break;
            }
            if (marked[i]) {
                list.add(line);
                sizeList--;
            }
        }
        return list;
    }

    public List<String> findDataByKeyword(String s) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("question.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> list = new ArrayList<>();
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            if (line.contains(s) == true) {
                list.add(line);
            }
        }
        return list;
    }

    public void deleteByKeyword(String s) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("question.txt");
        BufferedReader br = new BufferedReader(fr);
        String line ;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (line.contains(s) != true) {
                list.add(line);
            } else {
                sizeRow--;
            }
        }
        try (FileWriter fw = new FileWriter("question.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
                bw.newLine();
            }
            resetSizeRow();// cập nhật số câu hỏi
        }
    }

    public void resetSizeRow() throws IOException {
        try (FileWriter fw = new FileWriter("maxQuestion.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(String.valueOf(sizeRow));
        }
    }

}
