public class Person {
    private final String fornavn;
    private final String etternavn;
    private final int fodselsar;
    
    public Person(String fornavn, String etternavn, int fodselsar) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsar = fodselsar;
    }
    
    // Get-metoder
    public String getFornavn() {
        return fornavn;
    }
    
    public String getEtternavn() {
        return etternavn;
    }
    
    public int getFodselsar() {
        return fodselsar;
    }
    
    @Override
    public String toString() {
        return fornavn + " " + etternavn + " (" + fodselsar + ")";
    }
}