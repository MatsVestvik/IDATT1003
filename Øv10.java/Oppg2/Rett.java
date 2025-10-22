public class Rett {
    private String navn;
    private String type;
    private double pris;
    private String oppskrift;
    
    public Rett(String navn, String type, double pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }
    
    // Get-metoder
    public String getNavn() { return navn; }
    public String getType() { return type; }
    public double getPris() { return pris; }
    public String getOppskrift() { return oppskrift; }
    
    @Override
    public String toString() {
        return navn + " (" + type + ") - " + pris + " kr";
    }
}
