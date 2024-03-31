package view;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ShowQuestionAdmin {

    private JFrame f;

    public ShowQuestionAdmin(List<String> list) {
        f = new JFrame();
        String data[][] = new String[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Integer x = i + 1;
            data[i][0] = x.toString();
            data[i][1] = list.get(i);
        }
        if (list.isEmpty()) {
            data = new String[1][2];
            data[0][0] = "0";
            data[0][1] = "không tìm thấy";
        }
        String column[] = {"STT", "Question"};
        JTable table = new JTable(data, column);
        table.setBounds(30, 40, 200, 300);
        TableColumn column1 = table.getColumnModel().getColumn(0); 
        column1.setPreferredWidth(50); 
        TableColumn column2 = table.getColumnModel().getColumn(1);
        column2.setPreferredWidth(350); 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); 
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); 
        JScrollPane sp = new JScrollPane(table);
        f.add(sp);
        f.setSize(400, 500);
        f.setLocationRelativeTo(null);
        table.setBackground(Color.pink);
        f.getContentPane().setBackground(Color.pink);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
