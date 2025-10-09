/*Oppgave 1
Lag en klasse for å regne med brøk.
Klassen skal ha to konstruktører:
• Den ene konstruktøren tar teller og nevner som argument. Hvis nevneren er 0, skal et
unntaksobjekt av typen IllegalArgumentException kastes.
• Den andre konstruktøren tar kun telleren som argument. Da skal nevneren settes lik 1.
Klassen skal ha get-metoder, men ikke set-metoder.
Klassen skal ha metoder for å summere, subtrahere, multiplisere og dividere en brøk (this)
med en annen brøk (parameter til metoden). Metodene har ikke returverdi, men etter at
operasjonen er utført, ligger resultatet i this.
Du kan se bort fra at resultatet av operasjonen bør forkortes.
Lag testklient som del av klassen.
Ekstraoppgave: Sørg for å forkorte brøkene.
 */

import java.util.Scanner;

public class Oppgave1 {
    public static void main (String[] args){

        String tall1 = "";
        String teller1;
        String nevner1;
        int regneTeller1;
        int regneNevner1;
        //double regneTall1;

        String tall2 = "";
        String teller2;
        String nevner2;
        int regneTeller2;
        int regneNevner2;
        double regneTall2 = 2;

        char operator;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommer til Mats sin brøk kalkulator");
        System.out.print("Skriv inn første brøken for å starte(bruk / for mellom teller og nevner;):");

        tall1 = scanner.nextLine();
        teller1 = tall1.substring(0,tall1.indexOf("/"));
        nevner1 = tall1.substring(tall1.indexOf("/")+1);
        regneTeller1 = Integer.parseInt(teller1);
        regneNevner1 = Integer.parseInt(nevner1);
        //regneTall1 = settSammen(regneTeller1, regneNevner1);

        System.out.print("skriv inn operatøren du ønskerå bruke(+, -, *, /):");
        operator = scanner.nextLine().charAt(0);

        System.out.print("Skriv inn den andre brøken(bruk / for mellom teller og nevner;):");

        tall2 = scanner.nextLine();
        teller2 = tall2.substring(0,tall2.indexOf("/"));
        nevner2 = tall2.substring(tall2.indexOf("/")+1);
        regneTeller2 = Integer.parseInt(teller2);
        regneNevner2 = Integer.parseInt(nevner2);
        regneTall2 = settSammen(regneTeller2, regneNevner2);


        if (tall1.contains("/") && tall2.contains("/")) {
            String resultat = "1/1";
            int fellesNevner = 1;
            int tempTeller = 1;
            
            
            switch (operator) {
                case '+':
                    fellesNevner = regneNevner1 * regneNevner2;
                    tempTeller = regneTeller1*regneNevner2 + regneTeller2*regneNevner1;

                    resultat = tempTeller + "/" + fellesNevner;
                    break;
                case '-':
                    fellesNevner = regneNevner1 * regneNevner2;
                    tempTeller = regneTeller1*regneNevner2 - regneTeller2*regneNevner1;

                    resultat = tempTeller + "/" + fellesNevner;
                    break;
                case '*':
                    tempTeller = regneTeller1 * regneTeller2;
                    fellesNevner = regneNevner1 * regneNevner2;
                    resultat = tempTeller + "/" + fellesNevner;
                    break;
                case '/':
                    if (regneTall2 != 0) {
                        tempTeller = regneTeller1 * regneNevner2;
                        fellesNevner = regneNevner1 * regneTeller2;
                        resultat = tempTeller + "/" + fellesNevner;
                    } else {
                        System.out.println("Feil: Kan ikke dele på null!");
                        scanner.close();
                        return;
                    }
                    break;
                default:
                    System.out.println("Ugyldig operator!");
                    scanner.close();
                    return;
            }
            

            int sfd = gcd(Math.abs(tempTeller), Math.abs(fellesNevner));
            int forkortetTeller = tempTeller / sfd;
            int forkortetNevner = fellesNevner / sfd;

            resultat = forkortetTeller + "/" + forkortetNevner;
            
            System.out.println("Resultat: " + resultat);
        }

        scanner.close();
    }

    static double settSammen(int teller, int nevner) {
        if(nevner == 0){
            throw new IllegalArgumentException("Feil: Nevner kan ikke være 0!");
        }else{
            return (double) teller / nevner;
        }
        
        
    }

    static double toppTall(int teller){
        return teller;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}