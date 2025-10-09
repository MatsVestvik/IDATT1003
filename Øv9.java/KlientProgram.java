import java.util.Scanner;

public class KlientProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Oppgaveoversikt oversikt = new Oppgaveoversikt(10);
        
        // Legg til noen studenter til å begynne med
        oversikt.registrerNyStudent("Ola Nordmann");
        oversikt.registrerNyStudent("Kari Hansen");
        oversikt.registrerNyStudent("Per Olsen");
        
        // Gi dem noen oppgaver
        oversikt.økAntOppgForStudent("Ola Nordmann", 5);
        oversikt.økAntOppgForStudent("Kari Hansen", 3);
        oversikt.økAntOppgForStudent("Per Olsen", 7);
        
        while (true) {
            System.out.println("\n=== OPPGAVESYSTEM ===");
            System.out.println("1. Vis alle studenter");
            System.out.println("2. Registrer ny student");
            System.out.println("3. Øk antall oppgaver for student");
            System.out.println("4. Finn antall oppgaver for student");
            System.out.println("5. Avslutt");
            System.out.print("Valg: ");
            
            int valg = scanner.nextInt();
            scanner.nextLine(); // Konsumer newline
            
            switch (valg) {
                case 1:
                    System.out.println(oversikt.toString());
                    break;
                    
                case 2:
                    System.out.print("Skriv navn på ny student: ");
                    String nyttNavn = scanner.nextLine();
                    if (oversikt.registrerNyStudent(nyttNavn)) {
                        System.out.println("Student registrert!");
                    } else {
                        System.out.println("Kunne ikke registrere student.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Skriv navn på student: ");
                    String navnØk = scanner.nextLine();
                    System.out.print("Hvor mange oppgaver skal økes: ");
                    int økning = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (oversikt.økAntOppgForStudent(navnØk, økning)) {
                        System.out.println("Antall oppgaver økt for " + navnØk);
                    } else {
                        System.out.println("Student ikke funnet!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Skriv navn på student: ");
                    String navnFinn = scanner.nextLine();
                    int antOppgaver = oversikt.finnAntOppgaver(navnFinn);
                    if (antOppgaver != -1) {
                        System.out.println(navnFinn + " har " + antOppgaver + " godkjente oppgaver");
                    } else {
                        System.out.println("Student ikke funnet!");
                    }
                    break;
                    
                case 5:
                    System.out.println("Avslutter...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Ugyldig valg!");
            }
        }
    }
}