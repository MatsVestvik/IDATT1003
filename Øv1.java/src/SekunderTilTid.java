import java.util.Scanner;

public class SekunderTilTid {
    public static void main(String[] args) {
        // Opprett scanner for å lese input
        Scanner scanner = new Scanner(System.in);
        
        // Be brukeren om antall sekunder
        int totalSekunder = scanner.nextInt();
        
        // Lukk scanneren
        scanner.close();
        
        // Beregn timer, minutter og sekunder
        int timer = totalSekunder / 3600;
        int restSekunder = totalSekunder % 3600;
        int minutter = restSekunder / 60;
        int sekunder = restSekunder % 60;
        
        // Skriv ut resultatet
        System.out.printf("%d sekunder = %d timer, %d minutter og %d sekunder%n",totalSekunder, timer, minutter, sekunder);
    }
}