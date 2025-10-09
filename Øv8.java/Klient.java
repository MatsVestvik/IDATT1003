import java.util.Scanner;

public class Klient {
    private static ArbTaker arbTaker;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Opprett initialt objekt
        Person person = new Person("Kari", "Hansen", 1985);
        arbTaker = new ArbTaker(person, 67890, 2020, 45000, 0.28);
        
        while(true) {
            visMeny();
            int valg = scanner.nextInt();
            scanner.nextLine(); // Konsumer newline
            
            switch(valg) {
                case 1:
                    visData();
                    break;
                case 2:
                    endreMaanedslonn(scanner);
                    break;
                case 3:
                    endreSkatteprosent(scanner);
                    break;
                case 4:
                    System.out.println("Avslutter...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ugyldig valg!");
            }
        }
    }
    
    private static void visMeny() {
        System.out.println("\n=== ARBTAKER SYSTEM ===");
        System.out.println("1. Vis alle data");
        System.out.println("2. Endre månedslønn");
        System.out.println("3. Endre skatteprosent");
        System.out.println("4. Avslutt");
        System.out.print("Valg: ");
    }
    
    private static void visData() {
        System.out.println("\n=== ARBTAKER DATA ===");
        System.out.println("Navn: " + arbTaker.getNavnFormatert());
        System.out.println("Alder: " + arbTaker.getAlder() + " år");
        System.out.println("ArbTakerNr: " + arbTaker.getArbTakernr());
        System.out.println("Ansatt siden: " + arbTaker.getAnsettelsesar());
        System.out.println("År ansatt: " + arbTaker.getAntallArAnsatt() + " år");
        System.out.println("Månedslønn: " + arbTaker.getMaanedslonn() + " kr");
        System.out.println("Skatteprosent: " + (arbTaker.getSkatteprosent() * 100) + "%");
        System.out.println("Skatt per måned: " + arbTaker.skattPerMaaned() + " kr");
        System.out.println("Bruttolønn per år: " + arbTaker.bruttoLonnPerAr() + " kr");
        System.out.println("Skattetrekk per år: " + arbTaker.skattetrekkPerAr() + " kr");
        System.out.println("Ansatt mer enn 3 år: " + arbTaker.harVærtAnsattMerEnn(3));
    }
    
    private static void endreMaanedslonn(Scanner scanner) {
        System.out.print("Ny månedslønn: ");
        double nyLonn = scanner.nextDouble();
        arbTaker.setMaanedslonn(nyLonn);
        System.out.println("Månedslønn oppdatert til: " + arbTaker.getMaanedslonn() + " kr");
    }
    
    private static void endreSkatteprosent(Scanner scanner) {
        System.out.print("Ny skatteprosent (f.eks 30 for 30%): ");
        double nyProsent = scanner.nextDouble() / 100;
        arbTaker.setSkatteprosent(nyProsent);
        System.out.println("Skatteprosent oppdatert til: " + (arbTaker.getSkatteprosent() * 100) + "%");
    }
}