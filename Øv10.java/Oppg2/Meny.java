import java.util.ArrayList;
import java.util.List;

public class Meny{
    private List<Rett> retter;

    Meny(){
        retter = new ArrayList<>();
    }

    public int addDish(String name, String type, String oppskrift, double price){
        for(int i = 0; i<retter.size(); i++){
            if(name.equalsIgnoreCase(retter.get(i).getName())) {
                return -1;
            }
        }
        Rett nyRett = new Rett(name, type, oppskrift, price);
        retter.add(nyRett);
        return 1;
    }
}