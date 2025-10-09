/*Et år er skuddår dersom det er delelig med 4. Unntaket er hundreårene, de må være delelig
med 400.
Tegn aktivitetsdiagram som viser algoritmen for å finne ut om et år er skuddår. Årstallet skal
leses inn fra brukeren. Sett opp testdata. Lag og prøv ut programmet. */

import java.util.Scanner;

public class KontrollSkuddår {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("oppgi et årstall: ");
        int år = scanner.nextInt();

        boolean skuddår = (år % 4 == 0) && (år % 100 != 0 || år % 400 == 0);

        if (skuddår){
            System.out.print(år + " er et skuddår");
        }
        else {
            System.out.print(år + " er ikke et skuddår");
        }

        scanner.close();

    }
}