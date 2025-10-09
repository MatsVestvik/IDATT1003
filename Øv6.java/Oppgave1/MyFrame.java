package Oppgave1;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {
    JButton generate;
    JTable table;
    JScrollPane pane;
    String[] colName = {"Tall", "Antall", "Prosent"};
    int[] data = new int[10];
    Random random = new Random();
    DefaultTableModel model;

    MyFrame(){
        generate = new JButton("Generer tall");
        generate.setBounds(200, 50, 120, 30);
        generate.addActionListener(this);
        
        model = new DefaultTableModel(colName, 0);
        table = new JTable(model);
        pane = new JScrollPane(table);
        pane.setBounds(50, 100, 400, 300);

        this.setTitle("Random Number Distribution");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(500, 500);
        this.add(generate);
        this.add(pane);
        this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == generate){
            for (int i = 0; i < data.length; i++) {
                data[i] = 0;
            }
            
            for (int i = 0; i < 1000; i++) {
                int tall = random.nextInt(10); 
                data[tall]++; 
            }
            
            updateTable();
        }
    }
    
    private void updateTable() {

        model.setRowCount(0);
        
        for (int i = 0; i < data.length; i++) {
            double prosent = (data[i] * 100.0) / 1000;
            Object[] row = {i, data[i], String.format("%.1f%%", prosent)};
            model.addRow(row);
        }
    }
}