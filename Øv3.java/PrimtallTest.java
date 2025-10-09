import java.util.Scanner;

public class PrimtallTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("PrimtallTest");
        System.out.println("================");
        
        while (true) {
            System.out.print("\nSkriv inn et tall: ");
            
            if (scanner.hasNextInt()) {
                int tall = scanner.nextInt();
                
                if (tall < 2) {
                    System.out.println(tall + " er ikke et primtall (primtall må være større enn 1).");
                } else {
                    boolean erPrimtall = erPrimtall(tall);
                    
                    if (erPrimtall) {
                        System.out.println(tall + " er et primtall!");
                    } else {
                        System.out.println(tall + " er ikke et primtall.");
                    }
                }
            } else {
                System.out.println("Ugyldig input. Vennligst skriv et heltall.");
                scanner.next();
            }
        }
    }
    
    public static boolean erPrimtall(int tall) {
 
        for (int i = 2; i <= Math.sqrt(tall); i++) {
            if (tall % i == 0) {
                return false; 
            }
        }
        return true; 
    }
}