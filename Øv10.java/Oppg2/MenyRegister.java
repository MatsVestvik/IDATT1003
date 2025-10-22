import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class MenyRegister {
    private Map<String, Rett> retter; // Navn -> Rett
    private List<Meny> menyer;
    
    public MenyRegister() {
        this.retter = new HashMap<>();
        this.menyer = new ArrayList<>();
    }
    
    /**
     * Registrer en ny rett
     */
    public boolean registrerRett(String navn, String type, double pris, String oppskrift) {
        if (retter.containsKey(navn)) {
            return false; // Retten finnes allerede
        }
        retter.put(navn, new Rett(navn, type, pris, oppskrift));
        return true;
    }
    
    /**
     * Finn en rett gitt navnet
     */
    public Rett finnRett(String navn) {
        return retter.get(navn);
    }
    
    /**
     * Finn alle retter av en gitt type
     */
    public List<Rett> finnRetterAvType(String type) {
        return retter.values().stream()
                .filter(rett -> rett.getType().equalsIgnoreCase(type))
                .toList();
    }
    
    /**
     * Registrer en ny meny som består av et sett med retter
     */
    public boolean registrerMeny(String menyNavn, List<String> rettNavn) {
        List<Rett> menyRetter = new ArrayList<>();
        
        for (String navn : rettNavn) {
            Rett rett = finnRett(navn);
            if (rett == null) {
                return false; // En av rettene finnes ikke
            }
            menyRetter.add(rett);
        }
        
        menyer.add(new Meny(menyNavn, menyRetter));
        return true;
    }
    
    /**
     * Finn alle menyer med totalpris innenfor et gitt intervall
     */
    public List<Meny> finnMenyerIPrisintervall(double minPris, double maxPris) {
        return menyer.stream()
                .filter(meny -> {
                    double totalPris = meny.getTotalPris();
                    return totalPris >= minPris && totalPris <= maxPris;
                })
                .toList();
    }
    
    // Hjelpemetoder for testing/visning
    public List<Rett> getAlleRetter() {
        return new ArrayList<>(retter.values());
    }
    
    public List<Meny> getAlleMenyer() {
        return new ArrayList<>(menyer);
    }
}