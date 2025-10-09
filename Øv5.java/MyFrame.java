import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener{

    JButton buttonInt;
    JButton buttonDouble;
    JLabel label;
    double test = 0;
    double heltall = 0;
    double desimal = 0;

    Random random;

    MyFrame(){
        buttonInt = new JButton();
        buttonInt.setBounds(100,100,100,50);
        buttonInt.setText("heltall");
        buttonDouble = new JButton();
        buttonDouble.setBounds(300,100,100,50);
        buttonDouble.setText("desimaltall");
        label = new JLabel(Double.toString(test));
        label.setBounds(100,200,300,50);

        
        buttonInt.addActionListener(this);
        buttonDouble.addActionListener(this);

        this.setTitle("Random number generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.add(buttonInt);
        this.add(buttonDouble);
        this.add(label);
   }

    public int nextInt(int toppVerdi){
        random = new Random();
        return random.nextInt(toppVerdi + 1);

    }

    public double nextDouble(){
        random = new Random();
        return random.nextDouble();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== buttonInt){
            heltall = nextInt(20);
            test = heltall + desimal;
            label.setText(Double.toString(test));
        }
        if(e.getSource()==buttonDouble){
            desimal =  nextDouble();
            test = heltall + desimal;
            label.setText(Double.toString(test));
        }
    }
    
}