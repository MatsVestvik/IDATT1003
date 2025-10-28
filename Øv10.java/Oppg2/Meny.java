import java.util.ArrayList;
import java.util.List;

public class Meny{
    private List<Rett> retter;
    private String name;
    private int size = 0;

    Meny(String name){
        retter = new ArrayList<>();
        this.name = name;
    }

    public String getName() {return name;}

    public void addDish(Rett rett){
        retter.add(rett);
    }

    public int getSize(){return this.size;}

    public double getPrice(){
        double tot = 0;
        for(int i = 0; i < retter.size(); i++){
            tot += retter.get(i).getPrice();
        }
        return tot;
    }

    public void printMeny(){
        System.out.println("[Meny: " + name + "]          [Total price: " + getPrice() + "kr]");
        for(int i = 0; i < retter.size(); i++){
            System.out.println(retter.get(i).toString());
        }
        System.out.println();
    }

}