package Oppg1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangementRegister {
    private List<Arrangement> arrangementer;

    //konstruktør
    ArrangementRegister(){
        arrangementer = new ArrayList<>(); 
    }

    //registrer nytt arrangement
    public void regNewArrangement(String name, String location, String host, String type, int num, long time){
        Arrangement nytt = new Arrangement(name, location, host, type, num, time);
        arrangementer.add(nytt);
    }

    //get all in specific location
    public List<Arrangement> getAllPlace(String location){
        List<Arrangement> resultat = new ArrayList<>();
        for (Arrangement arr : arrangementer){
            if (arr.getLocation().equalsIgnoreCase(location)){
                resultat.add(arr);
            }
        }
        return resultat;
    }

    //get all in specific time (dato - første 8 sifre)
    public List<Arrangement> getAllTime(long date){
        List<Arrangement> resultat = new ArrayList<>();
        for (Arrangement arr : arrangementer){
            long arrDato = arr.getTime() / 10000; // Fjern klokkeslett (siste 4 sifre)
            if(arrDato == date){
                resultat.add(arr);
            }
        } 
        return resultat;
    }

    //get all inbetween specific time 
    public List<Arrangement> getTheseTime(long dateStart, long dateStop){
        List<Arrangement> resultat = new ArrayList<>();
        for (Arrangement arr : arrangementer){
            if (arr.getTime() >= dateStart && arr.getTime() <= dateStop){
                resultat.add(arr);
            }
        }
        Collections.sort(resultat);
        return resultat;
    }

    // Lister sortert etter sted
    public List<Arrangement> sortertEtterSted() {
        List<Arrangement> kopi = new ArrayList<>(arrangementer);
        Collections.sort(kopi, new Comparator<Arrangement>() {
            @Override
            public int compare(Arrangement a1, Arrangement a2) {
                return a1.getLocation().compareToIgnoreCase(a2.getLocation());
            }
        });
        return kopi;
    }
    
    // Lister sortert etter type
    public List<Arrangement> sortertEtterType() {
        List<Arrangement> kopi = new ArrayList<>(arrangementer);
        Collections.sort(kopi, new Comparator<Arrangement>() {
            @Override
            public int compare(Arrangement a1, Arrangement a2) {
                return a1.getType().compareToIgnoreCase(a2.getType());
            }
        });
        return kopi;
    }
    
    // Lister sortert etter tidspunkt
    public List<Arrangement> sortertEtterTid() {
        List<Arrangement> kopi = new ArrayList<>(arrangementer);
        Collections.sort(kopi);
        return kopi;
    }

    //get all arrangements
    public List<Arrangement> getAlleArrangementer() {
        return new ArrayList<>(arrangementer);
    }
}