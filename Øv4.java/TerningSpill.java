import java.util.Scanner;

public class TerningSpill {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til Mats sitt terningspill!!!");
        System.out.println("_____________________________________________");
        System.out.println("Skriv inn navnet på spiller A:");

        String navnA = scanner.nextLine();
        Spiller spillerA = new Spiller(navnA);

        System.out.println("Skriv inn navnet på spiller B:");

        String navnB = scanner.nextLine();
        Spiller spillerB = new Spiller(navnB);

        System.out.println("Reglene er enkle, det er førstemann til hundre poeng,");
        System.out.println("kaster du en 1 blir poengsummen tilbakestilt.");
        System.out.println("Skriv 1 for å starte spillet:");

        int start = scanner.nextInt();

        if(start == 1){
            System.out.println("Game start!");
            System.out.println(spillerA.getNavn() + " vs " + spillerB.getNavn());
            System.out.println("_____________________________________________");
            
            int runde = 1;
            
            while (!spillerA.erFerdig() && !spillerB.erFerdig()) {
                System.out.println("\nRunde " + runde + ":");
                
                // Spiller A sin tur
                int kastA = spillerA.kastTerningen();
                System.out.println(spillerA.getNavn() + " kastet: " + kastA + 
                                 ", Sum: " + spillerA.getSumPoeng());
                
                if (spillerA.erFerdig()) {
                    System.out.println(spillerA.getNavn() + " har vunnet!");
                    break;
                }
                
                // Spiller B sin tur
                int kastB = spillerB.kastTerningen();
                System.out.println(spillerB.getNavn() + " kastet: " + kastB + 
                                 ", Sum: " + spillerB.getSumPoeng());
                
                if (spillerB.erFerdig()) {
                    System.out.println(spillerB.getNavn() + " har vunnet!");
                    break;
                }
                
                runde++;
            }
            
            System.out.println("\n_____________________________________________");
            System.out.println("Spillet er over!");
            System.out.println("Finale resultater:");
            System.out.println(spillerA.getNavn() + ": " + spillerA.getSumPoeng() + " poeng");
            System.out.println(spillerB.getNavn() + ": " + spillerB.getSumPoeng() + " poeng");
            
        } else {
            System.out.println("Hadebra!");
        }

        scanner.close();
    }
}