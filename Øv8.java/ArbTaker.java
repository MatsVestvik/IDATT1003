import java.util.GregorianCalendar;

public class ArbTaker {
    private final Person personalia;
    private int arbtakernr;
    private int ansettelsesar;
    private double maanedslonn;
    private double skatteprosent;
    
    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesar, 
                   double maanedslonn, double skatteprosent) {
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesar = ansettelsesar;
        this.maanedslonn = maanedslonn;
        this.skatteprosent = skatteprosent;
    }
    
    // Get-metoder
    public Person getPersonalia() {
        return personalia;
    }
    
    public int getArbTakernr() {
        return arbtakernr;
    }
    
    public int getAnsettelsesar() {
        return ansettelsesar;
    }
    
    public double getMaanedslonn() {
        return maanedslonn;
    }
    
    public double getSkatteprosent() {
        return skatteprosent;
    }
    
    // Set-metoder for attributter som kan endres
    public void setMaanedslonn(double maanedslonn) {
        this.maanedslonn = maanedslonn;
    }
    
    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }
    
    // Operasjoner
    
    /**
     * Skatt per måned (normal måned)
     */
    public double skattPerMaaned() {
        return maanedslonn * skatteprosent;
    }
    
    /**
     * Bruttolønn per år
     */
    public double bruttoLonnPerAr() {
        return maanedslonn * 10.5; // 10.5 måneder pga skattefrie måneder
    }
    
    /**
     * Skattetrekk per år
     */
    public double skattetrekkPerAr() {
        // Juni: 0% skatt, Desember: 50% skatt, andre måneder: 100% skatt
        return (maanedslonn * skatteprosent * 10) + (maanedslonn * skatteprosent * 0.5);
    }
    
    /**
     * Navn på formen: etternavn, fornavn
     */
    public String getNavnFormatert() {
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }
    
    /**
     * Alder
     */
    public int getAlder() {
        GregorianCalendar kalender = new GregorianCalendar();
        int ar = kalender.get(java.util.Calendar.YEAR);
        return ar - personalia.getFodselsar();
    }
    
    /**
     * Antall år ansatt i bedriften
     */
    public int getAntallArAnsatt() {
        GregorianCalendar kalender = new GregorianCalendar();
        int ar = kalender.get(java.util.Calendar.YEAR);
        return ar - ansettelsesar;
    }
    
    /**
     * Om personen har vært ansatt mer enn et gitt antall år
     */
    public boolean harVærtAnsattMerEnn(int antallAr) {
        return getAntallArAnsatt() > antallAr;
    }
    
    /**
     * Get navn (for enkelthetsskyld)
     */
    public String getNavn() {
        return personalia.getFornavn() + " " + personalia.getEtternavn();
    }
    
    @Override
    public String toString() {
        return "ArbTaker{" +
                "navn=" + getNavnFormatert() +
                ", arbtakernr=" + arbtakernr +
                ", ansettelsesar=" + ansettelsesar +
                ", maanedslonn=" + maanedslonn +
                ", skatteprosent=" + (skatteprosent * 100) + "%" +
                '}';
    }
}