import java.util.Scanner;

public class ValutaKalkulator {
        
    public static void main(String[] args) {

        float usdCon = 9.86f;
        float eurCon = 11.58f;
        float sekCon = 1.06f;
        float konstant = 0;
        String navnPaa = "";
        boolean gyldigValg = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println(
            """
            Velg valuta:
            1: dollar
            2: euro
            3: svenske kroner
            4: avslutt
            """
        );

        int navn = scanner.nextInt();

        switch (navn) {
            case 1:
                konstant = usdCon;
                navnPaa = "$";
                System.out.println("du har valgt dollar");
                break;

            case 2:
                konstant = eurCon;
                navnPaa = "euro";
                System.out.println("du har valgt euro");
                break;

            case 3:
                navnPaa = "Svenske kroner";
                konstant = sekCon;
                System.out.println("du har valgt Svenske kroner");
                break;
        
            case 4:
                gyldigValg = false;
                System.out.println("Hade bra!!");
                break;
                
            default:
                gyldigValg = false;
                System.out.println("Ugyldig valg!");
                break;
        }

        if (gyldigValg && navn != 4) {
            System.out.println("Velg retning:");
            System.out.println("1: " + navnPaa + " -> NOK");
            System.out.println("2: NOK -> " + navnPaa);
            System.out.println("3: avslutt");
            
            int rettning = scanner.nextInt();
            
            System.out.println("Skriv inn mengde " + navnPaa + " du ønsker oversatt");
            float mengde = scanner.nextFloat();

            Valuta valuta = new Valuta(navnPaa);
            float resultat;
            
            if (rettning == 1) {
                resultat = valuta.valutaTilNok(mengde, konstant);
                System.out.println(mengde + " " + navnPaa + " = " + resultat + " NOK");
            } else if (rettning == 2) {
                resultat = valuta.valutaFraNok(mengde, konstant);
                System.out.println(mengde + " NOK = " + resultat + " " + navnPaa);
            } else if (rettning == 3) {
                System.out.println("Hade bra!!");
            } else {
                System.out.println("Ugyldig retning valgt!");
            }
        }

        scanner.close();
    }
}