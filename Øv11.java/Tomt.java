public class Tomt {
    private String kommuneNavn;
    private int kommuneNr;
    private int gaardsNr;
    private int bruksNr;
    private String bruksNavn;
    private double areal;
    private String eier;

    Tomt(String kommuneNavn, int kommuneNr, int gaardsNr,
     int bruksNr, String bruksNavn, double areal, String eier){
        this.kommuneNavn = kommuneNavn;
        this.kommuneNr = kommuneNr;
        this.gaardsNr = gaardsNr;
        this.bruksNr = bruksNr;
        this.bruksNavn = bruksNavn;
        this.areal = areal;
        this.eier = eier;
    }

    public String getKommuneNavn() {return kommuneNavn;}
    public int getKommuneNr() {return kommuneNr;}
    public int getGaardsNr() {return gaardsNr;}
    public int getBruksNr() {return bruksNr;}
    public String getBruksNavn() {return bruksNavn;}
    public double getAreal() {return areal;}
    public String getEier() {return eier;}

    @Override
    public String toString(){
        return String.format("kommuneNavn: %s | kommuneNr: %d | gaardsNr: %d | bruksNr: %d | bruksNavn: %s | areal: %s | eier: %s"
        , kommuneNavn, kommuneNr, gaardsNr, bruksNr, bruksNavn, areal, eier);
    }
}
