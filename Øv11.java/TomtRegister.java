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

    public void getTomt(String unikID){
        for(int i = 0; i<tomter.size(); i++){
            if (unikID.equals(tomter.get(i).getUnikID())){
                System.out.println(tomter.get(i).toString());
            }
        }
    }

    public double getAvrgArea(){
        double totalArea = 0;
        for(int i = 0; i<tomter.size(); i++){
            totalArea += tomter.get(i).getAreal();
        }
        return totalArea/tomter.size();
    }    

    public void getAllGnr(int gnr){
        
        for(int i = 0; i<tomter.size(); i++){
            if(gnr == tomter.get(i).getGaardsNr()){
                System.out.println(tomter.get(i));
            }
        }
        System.out.println();
    }

    public void getAllKommuneNr(int knr){
        for(int i = 0; i < tomter.size(); i++){
            if (knr == tomter.get(i).getGaardsNr()){
                System.out.println(tomter.get(i));
            }
        }
    }

    public void getAll(){
        for(int i = 0; i < tomter.size(); i++){
            System.out.println(tomter.get(i));
        };
    }

    
}
