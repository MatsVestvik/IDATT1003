import java.util.List;
import java.util.ArrayList;

public class TomtRegister {
    private List<Tomt> tomter;

    TomtRegister(){
        tomter = new ArrayList<>();
    }

    public void addTomt(String kommuneNavn, int kommuneNr, int gaardsNr,
     int bruksNr, String bruksNavn, double areal, String eier){
        Tomt newTomt = new Tomt(kommuneNavn, kommuneNr, gaardsNr, bruksNr, bruksNavn, areal, eier);
        tomter.add(newTomt);
    }

    public void removeTomt(String unikID){
        for(int i = 0; i< tomter.size(); i++){
            if (unikID.equals(getUnikID(i))) {
                tomter.remove(i);
            }
        }
    }

    public String getUnikID(int index){
        return tomter.get(index).getUnikID();
    }

    public int getNumOfProp(){return tomter.size();}

    public Tomt getTomt(String unikID){
        for(int i = 0; i<tomter.size(); i++){
            if (unikID.equals(tomter.get(i).getUnikID())){
                return tomter.get(i);
            }
        }
        return null;
    }

    public void getAll(){
        for(int i = 0; i < tomter.size(); i++){
            System.out.println(tomter.get(i));
        };
    }

    
}
