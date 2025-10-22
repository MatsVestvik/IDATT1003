// Arrangement-klassen
class Arrangement {
    private int id;
    private String navn;
    private String sted;
    private String arrangor;
    private String type;
    private long tidspunkt;
    
    public Arrangement(int id, String navn, String sted, String arrangor, String type, long tidspunkt) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }
    
    // Get-metoder
    public int getId() { return id; }
    public String getNavn() { return navn; }
    public String getSted() { return sted; }
    public String getArrangor() { return arrangor; }
    public String getType() { return type; }
    public long getTidspunkt() { return tidspunkt; }
    
    // Hjelpemetode for å få dato-delen fra tidspunkt (YYYYMMDD)
    public int getDato() {
        return (int)(tidspunkt / 10000);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | %s | Sted: %s | Type: %s | Tid: %d | Arrangør: %s", 
                           id, navn, sted, type, tidspunkt, arrangor);
    }
}