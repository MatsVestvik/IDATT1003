package Oppagve2;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TekstAnalyse extends JFrame implements ActionListener {

    JButton analyze;
    JTable table;
    JScrollPane pane;
    JTextArea text;
    DefaultTableModel model;

    String[] cols = {"Tegn", "Antall", "Prosent"};
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Æ", "Ø", "Å", "Andre tegn"};
    int[] numLetters = new int[30]; // 26 engelske + 3 norske + andre tegn

    TekstAnalyse(){
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        pane = new JScrollPane(table);
        pane.setBounds(250,25,240,575);
        analyze = new JButton("Analyze");
        analyze.setBounds(250, 0, 250,25);
        text = new JTextArea();
        text.setBounds(0,0,240, 600);

        analyze.addActionListener(this);

        this.setSize(500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        this.add(pane);
        this.add(analyze);
        this.add(text);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == analyze){
            
            for (int i = 0; i < numLetters.length; i++) {
                numLetters[i] = 0;
            }
            
            
            String inputText = text.getText().toUpperCase();
            int totalCharacters = inputText.length(); 
            
            // Count each character
            for (char c : inputText.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    numLetters[c - 'A']++; // A-Z: index 0-25
                } else if (c == 'Æ') {
                    numLetters[26]++; // Æ: index 26
                } else if (c == 'Ø') {
                    numLetters[27]++; // Ø: index 27
                } else if (c == 'Å') {
                    numLetters[28]++; // Å: index 28
                } else {
                    numLetters[29]++; // Other characters: index 29
                }
            }
            
            updateTable(totalCharacters);
        }
    }

    private void updateTable(int totalCharacters) {
        model.setRowCount(0); 
        
        for (int i = 0; i < numLetters.length; i++) {
            double prosent = 0.0;
            if (totalCharacters > 0) {
                prosent = (numLetters[i] * 100.0) / totalCharacters;
            }
            Object[] row = {letters[i], numLetters[i], String.format("%.2f%%", prosent)};
            model.addRow(row);
        }
    }

}