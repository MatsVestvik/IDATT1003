package Oppg1;
import java.util.List;
import java.util.Scanner;

public class TuristKontorKlient {
    private ArrangementRegister register;
    private Scanner scanner;
    private int nesteNummer;
    
    public TuristKontorKlient() {
        register = new ArrangementRegister();
        scanner = new Scanner(System.in);
        nesteNummer = 1;
        leggTilEksempelData();
    }
    
    private void leggTilEksempelData() {
        // Legg til noen eksempelarrangementer
        register.regNewArrangement("Konsert i parken", "Stavanger", "Kulturhuset", "Konsert", nesteNummer++, 202410151900L);
        register.regNewArrangement("Barneteater", "Bergen", "Teateret", "Barneteater", nesteNummer++, 202410201400L);
        register.regNewArrangement("Kunstforedrag", "Oslo", "Kunstmuseet", "Foredrag", nesteNummer++, 202410251800L);
        register.regNewArrangement("Jazzfestival", "Stavanger", "Jazzklubben", "Konsert", nesteNummer++, 202411011900L);
        register.regNewArrangement("Vikingutstilling", "Bergen", "Historisk museum", "Utstilling", nesteNummer++, 202411051000L);
        System.out.println("Eksempeldata lagt til!");
    }
    
    public void kjor() {
        boolean fortsett = true;
        
        while (fortsett) {
            visMeny();
            int valg = lesHelTall("Velg et alternativ: ");
            
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
                    System.out.println("Avslutter programmet...");
                    break;
                default:
                    System.out.println("Ugyldig valg! Prøv igjen.");
            }
        }
        scanner.close();
    }
    
    private void visMeny() {
        System.out.println("\n=== TURISTKONTORETS ARRANGEMENTREGISTER ===");
        System.out.println("1. Registrer nytt arrangement");
        System.out.println("2. Finn arrangementer på et sted");
        System.out.println("3. Finn arrangementer på en dato");
        System.out.println("4. Finn arrangementer i tidsintervall");
        System.out.println("5. Vis sorterte lister");
        System.out.println("6. Vis alle arrangementer");
        System.out.println("0. Avslutt");
        System.out.println("===========================================");
    }
    
    private void registrerNyttArrangement() {
        System.out.println("\n--- Registrer nytt arrangement ---");
        
        System.out.print("Navn på arrangement: ");
        String navn = scanner.nextLine();
        
        System.out.print("Sted: ");
        String sted = scanner.nextLine();
        
        System.out.print("Arrangør: ");
        String arrangor = scanner.nextLine();
        
        System.out.print("Type (konsert, barneteater, foredrag, etc.): ");
        String type = scanner.nextLine();
        
        long tidspunkt = lesLangTall("Tidspunkt (YYYYMMDDHHMM): ");
        
        register.regNewArrangement(navn, sted, arrangor, type, nesteNummer, tidspunkt);
        System.out.println("Arrangement registrert med nummer: " + nesteNummer);
        nesteNummer++;
    }
    
    private void finnArrangementerPaaSted() {
        System.out.print("\nSkriv inn sted: ");
        String sted = scanner.nextLine();
        
        List<Arrangement> resultat = register.getAllPlace(sted);
        visArrangementListe(resultat, "Arrangementer på " + sted);
    }
    
    private void finnArrangementerPaaDato() {
        long dato = lesLangTall("\nSkriv inn dato (YYYYMMDD): ");
        
        List<Arrangement> resultat = register.getAllTime(dato);
        visArrangementListe(resultat, "Arrangementer på dato " + dato);
    }
    
    private void finnArrangementerIIntervall() {
        System.out.println("\n--- Finn arrangementer i tidsintervall ---");
        long fraDato = lesLangTall("Fra dato (YYYYMMDD): ");
        long tilDato = lesLangTall("Til dato (YYYYMMDD): ");
        
        // Konverter til fullt tidspunkt for intervall
        long fraTid = fraDato * 10000L;
        long tilTid = (tilDato + 1) * 10000L; // Inkluder hele siste dagen
        
        List<Arrangement> resultat = register.getTheseTime(fraTid, tilTid);
        visArrangementListe(resultat, "Arrangementer fra " + fraDato + " til " + tilDato);
    }
    
    private void visSorterteLister() {
        System.out.println("\n--- Sorterte lister ---");
        
        System.out.println("1. Sortert etter sted");
        System.out.println("2. Sortert etter type"); 
        System.out.println("3. Sortert etter tid");
        System.out.println("4. Alle sorteringsmåter");
        
        int valg = lesHelTall("Velg sortering: ");
        
        switch (valg) {
            case 1:
                visArrangementListe(register.sortertEtterSted(), "Arrangementer sortert etter STED");
                break;
            case 2:
                visArrangementListe(register.sortertEtterType(), "Arrangementer sortert etter TYPE");
                break;
            case 3:
                visArrangementListe(register.sortertEtterTid(), "Arrangementer sortert etter TID");
                break;
            case 4:
                visAlleSorterteLister();
                break;
            default:
                System.out.println("Ugyldig valg!");
        }
    }
    
    private void visAlleSorterteLister() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALLE ARRANGEMENTER - SORTERT PÅ ULIKE MÅTER");
        System.out.println("=".repeat(60));
        
        System.out.println("\n--- SORTERT ETTER STED ---");
        List<Arrangement> etterSted = register.sortertEtterSted();
        for (Arrangement arr : etterSted) {
            System.out.println(arr);
        }
        
        System.out.println("\n--- SORTERT ETTER TYPE ---");
        List<Arrangement> etterType = register.sortertEtterType();
        for (Arrangement arr : etterType) {
            System.out.println(arr);
        }
        
        System.out.println("\n--- SORTERT ETTER TIDSPUNKT ---");
        List<Arrangement> etterTid = register.sortertEtterTid();
        for (Arrangement arr : etterTid) {
            System.out.println(arr);
        }
    }
    
    private void visAlleArrangementer() {
        List<Arrangement> alle = register.getAlleArrangementer();
        visArrangementListe(alle, "Alle arrangementer");
    }
    
    private void visArrangementListe(List<Arrangement> arrangementer, String tittel) {
        System.out.println("\n--- " + tittel + " ---");
        if (arrangementer.isEmpty()) {
            System.out.println("Ingen arrangementer funnet.");
        } else {
            for (Arrangement arr : arrangementer) {
                System.out.println(arr);
            }
            System.out.println("Antall arrangementer: " + arrangementer.size());
        }
    }
    
    private int lesHelTall(String melding) {
        while (true) {
            try {
                System.out.print(melding);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig tall! Prøv igjen.");
            }
        }
    }
    
    private long lesLangTall(String melding) {
        while (true) {
            try {
                System.out.print(melding);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig tall! Prøv igjen.");
            }
        }
    }
    
    public static void main(String[] args) {
        TuristKontorKlient klient = new TuristKontorKlient();
        klient.kjor();
    }
}