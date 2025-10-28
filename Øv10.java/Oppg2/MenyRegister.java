import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class MenyRegister{
    private HashMap<String, Rett> retter;
    private List<Meny> menyer;
    
    MenyRegister(){
        retter = new HashMap<>();
        menyer = new ArrayList<>();
    }

    public void addDish(String name, String type, String oppskrift, double price) {
        Rett nyRett = new Rett(name, type, oppskrift, price);
        retter.put(name, nyRett);
    }

    public void addMeny(String name){
        Meny nyMeny = new Meny(name);
        menyer.add(nyMeny);
    }

    public Rett findRett(String rett){return retter.get(rett);}
    public Meny findMeny(String name){
        for (Meny meny : menyer) {
            if (meny.getName().equalsIgnoreCase(name)) {
                return meny;
            }
        }
        return null;
    }

    public void findRettType(String kategori) {
        for (Rett rett : retter.values()) {
            if (rett.getType().equalsIgnoreCase(kategori)) {
                System.out.println(rett);
            }
        }
        System.out.println();
    }

    public void finnMenyerInnenforPrisintervall(double minPris, double maxPris) {
        for (Meny meny : menyer) {
            double totalPris = meny.getPrice();
            if (totalPris >= minPris && totalPris <= maxPris) {
                meny.printMeny();
            }
        }
        System.out.println();
    }

    public void addDTM(String menyName, String dishName){
        Meny meny = findMeny(menyName);
        Rett dish = findRett(dishName);

        if (meny != null && dish != null) {
            meny.addDish(dish);
        }

    }

    public void printRegister(){
        for(int i = 0; i < menyer.size(); i++){
            System.out.println();
            menyer.get(i).printMeny();
        }
    }


}