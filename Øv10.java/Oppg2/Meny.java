import java.util.List;
import java.util.ArrayList;

public class Meny {
    private String navn;
    private List<Rett> retter;
    
    public Meny(String navn, List<Rett> retter) {
        this.navn = navn;
        this.retter = new ArrayList<>(retter);
    }
    
    // Beregn totalpris for menyen
    public double getTotalPris() {
        return retter.stream()
                .mapToDouble(Rett::getPris)
                .sum();
    }
    
    // Get-metoder
    public String getNavn() { return navn; }
    public List<Rett> getRetter() { return new ArrayList<>(retter); }
    
    @Override
    public String toString() {
        return navn + " - Totalpris: " + getTotalPris() + " kr";
    }
}