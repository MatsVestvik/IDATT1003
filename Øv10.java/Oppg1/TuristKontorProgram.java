
// Klientprogram med meny

import java.util.List;
import java.util.Scanner;

public class TuristKontorProgram {
    private static ArrangementRegister register = new ArrangementRegister();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Legg til noen eksempelarrangementer
        leggTilEksempelData();
        
        boolean fortsett = true;
        while (fortsett) {
            visMeny();
            int valg = scanner.nextInt();
            scanner.nextLine(); // Konsumer newline
            
            switch (valg) {
                case 1:
                    registrerNyttArrangement();
                    break;
                case 2:
                    finnArrangementerPaaSted();
                    break;
                case 3:
                    finnArrangementerPaaDato();
                    break;
                case 4:
                    finnArrangementerIIntervall();
                    break;
                case 5:
                    visSorterteLister();
                    break;
                case 6:
                    visAlleArrangementer();
                    break;
                case 0:
                    fortsett = false;
                    System.out.println("bye bye");
                    break;
                default:
                    System.out.println("hwhat did you say");
            }
        }
        scanner.close();
    }
    
    private static void visMeny() {
        System.out.println("\nvelg et alternativ");
        System.out.println("1. Registrer nytt arrangement");
        System.out.println("2. Finn arrangementer på et sted");
        System.out.println("3. Finn arrangementer på en dato");
        System.out.println("4. Finn arrangementer i et tidsintervall");
        System.out.println("5. Vis sorterte lister");
        System.out.println("6. Vis alle arrangementer");
        System.out.println("0. Avslutt");
    }
    
    private static void registrerNyttArrangement() {
        System.out.println("\nRegistrer et arrangement");
        
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        
        System.out.print("Sted: ");
        String sted = scanner.nextLine();
        
        System.out.print("Arrangør: ");
        String arrangor = scanner.nextLine();
        
        System.out.print("Type: ");
        String type = scanner.nextLine();
        
        System.out.print("Tidspunkt (YYYYMMDDHHMM): ");
        long tidspunkt = scanner.nextLong();
        scanner.nextLine();
        
        boolean suksess = register.registrerArrangement(id, navn, sted, arrangor, type, tidspunkt);
        if (suksess) {
            System.out.println("Arrangement registrert!");
        } else {
            System.out.println("Oops noe gikk galt. prov igjen");
        }
    }
    
    private static void finnArrangementerPaaSted() {
        System.out.print("Skriv inn sted: ");
        String sted = scanner.nextLine();
        
        List<Arrangement> resultater = register.finnArrangementerPaaSted(sted);
        visResultater(resultater, "Arrangementer på " + sted);
    }
    
    private static void finnArrangementerPaaDato() {
        System.out.print("Skriv inn dato (YYYYMMDD): ");
        int dato = scanner.nextInt();
        scanner.nextLine();
        
        List<Arrangement> resultater = register.finnArrangementerPaaDato(dato);
        visResultater(resultater, "Arrangementer på dato " + dato);
    }
    
    private static void finnArrangementerIIntervall() {
        System.out.print("Startdato (YYYYMMDD): ");
        int startDato = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Sluttdato (YYYYMMDD): ");
        int sluttDato = scanner.nextInt();
        scanner.nextLine();
        
        List<Arrangement> resultater = register.finnArrangementerIIntervall(startDato, sluttDato);
        visResultater(resultater, "Arrangementer i perioden " + startDato + " - " + sluttDato);
    }
    
    private static void visSorterteLister() {
        System.out.println("\n--- SORTERTE LISTER ---");
        System.out.println("1. Sortert etter sted");
        System.out.println("2. Sortert etter type");
        System.out.println("3. Sortert etter tid");
        System.out.print("Velg sortering: ");
        
        int valg = scanner.nextInt();
        scanner.nextLine();
        
        List<Arrangement> sortertListe;
        String tittel;
        
        switch (valg) {
            case 1:
                sortertListe = register.sortertEtterSted();
                tittel = "Arrangementer sortert etter sted";
                break;
            case 2:
                sortertListe = register.sortertEtterType();
                tittel = "Arrangementer sortert etter type";
                break;
            case 3:
                sortertListe = register.sortertEtterTid();
                tittel = "Arrangementer sortert etter tid";
                break;
            default:
                System.out.println("Ugyldig valg.");
                return;
        }
        
        visResultater(sortertListe, tittel);
    }
    
    private static void visAlleArrangementer() {
        List<Arrangement> alleArrangementer = register.getAlleArrangementer();
        visResultater(alleArrangementer, "Alle arrangementer");
    }
    
    private static void visResultater(List<Arrangement> arrangementer, String tittel) {
        System.out.println("\n--- " + tittel + " ---");
        if (arrangementer.isEmpty()) {
            System.out.println("Ingen arrangementer funnet.");
        } else {
            for (Arrangement arr : arrangementer) {
                System.out.println(arr);
            }
            System.out.println("Totalt: " + arrangementer.size() + " arrangementer");
        }
    }
    
    private static void leggTilEksempelData() {
        register.registrerArrangement(1, "Sommerkonsert", "Stranda", "Byorkesteret", "Konsert", 202405151900L);
        register.registrerArrangement(2, "Barneteater", "Kulturhuset", "Teatergruppa", "Barneteater", 202405201400L);
        register.registrerArrangement(3, "Foredrag om historie", "Biblioteket", "Historielaget", "Foredrag", 202405181800L);
        register.registrerArrangement(4, "Jazzfest", "Stranda", "Jazzklubben", "Konsert", 202405251900L);
        register.registrerArrangement(5, "Kunstutstilling", "Kunstmuseet", "Kunstforeningen", "Utstilling", 202406011000L);
    }
    
}