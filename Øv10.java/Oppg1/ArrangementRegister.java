// ArrangementRegister-klassen

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ArrangementRegister {
    private List<Arrangement> arrangementer;
    
    public ArrangementRegister() {
        arrangementer = new ArrayList<>();
    }
    
    // Registrer nytt arrangement
    public boolean registrerArrangement(int id, String navn, String sted, String arrangor, String type, long tidspunkt) {
        // Sjekk om ID allerede finnes
        for (Arrangement arr : arrangementer) {
            if (arr.getId() == id) {
                return false; // ID finnes allerede
            }
        }
        
        Arrangement nyttArrangement = new Arrangement(id, navn, sted, arrangor, type, tidspunkt);
        arrangementer.add(nyttArrangement);
        return true;
    }
    
    // Finn alle arrangementer på et gitt sted
    public List<Arrangement> finnArrangementerPaaSted(String sted) {
        return arrangementer.stream()
                .filter(arr -> arr.getSted().equalsIgnoreCase(sted))
                .sorted(Comparator.comparing(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }
    
    // Finn alle arrangementer på en gitt dato (YYYYMMDD)
    public List<Arrangement> finnArrangementerPaaDato(int dato) {
        return arrangementer.stream()
                .filter(arr -> arr.getDato() == dato)
                .sorted(Comparator.comparing(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }
    
    // Finn alle arrangementer innenfor et tidsintervall
    public List<Arrangement> finnArrangementerIIntervall(int startDato, int sluttDato) {
        return arrangementer.stream()
                .filter(arr -> {
                    int arrDato = arr.getDato();
                    return arrDato >= startDato && arrDato <= sluttDato;
                })
                .sorted(Comparator.comparing(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }
    
    // Lister sortert etter sted
    public List<Arrangement> sortertEtterSted() {
        return arrangementer.stream()
                .sorted(Comparator.comparing(Arrangement::getSted))
                .collect(Collectors.toList());
    }
    
    // Lister sortert etter type
    public List<Arrangement> sortertEtterType() {
        return arrangementer.stream()
                .sorted(Comparator.comparing(Arrangement::getType))
                .collect(Collectors.toList());
    }
    
    // Lister sortert etter tidspunkt
    public List<Arrangement> sortertEtterTid() {
        return arrangementer.stream()
                .sorted(Comparator.comparing(Arrangement::getTidspunkt))
                .collect(Collectors.toList());
    }
    
    // Hent alle arrangementer
    public List<Arrangement> getAlleArrangementer() {
        return new ArrayList<>(arrangementer);
    }
}