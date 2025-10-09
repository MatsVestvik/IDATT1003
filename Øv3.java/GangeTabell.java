import java.util.Scanner;
public class GangeTabell {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start value");

        int start = scanner.nextInt();

        System.out.println("Enter stop value");

        int slutt = scanner.nextInt();
        
        for (int tall = start; tall <= slutt; tall++) {
            System.out.println("Multiplikasjonstabellen for " + tall + ":");
            System.out.println();
            
            for (int i = 1; i <= 10; i++) {
                int resultat = tall * i;
                System.out.println(tall + " × " + i + " = " + resultat);
            }
            
            System.out.println();
            System.out.println("--------------------");
            System.out.println();

            scanner.close();
        }
    }
}