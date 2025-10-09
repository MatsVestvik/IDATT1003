package Oppgave3;

public class MatriseTest {
    public static void main(String[] args) {
        
        Matrise A = new Matrise(new int[][]{
            {1,2},
            {3,4}
        });
        
        Matrise B = new Matrise(new int[][]{
            {1,2},
            {3,4}
        });
        
        System.out.println("Matrise A:");
        A.skrivUt();
        
        System.out.println("Matrise B:");
        B.skrivUt();
        
        System.out.println("A + B:");
        Matrise sum = A.addere(B);
        if (sum != null) {
            sum.skrivUt();
        }
        
        System.out.println("A x B:");
        Matrise produkt = A.multiplisere(B);
        if (produkt != null) {
            produkt.skrivUt();
        }
        
        System.out.println("A transponert:");
        Matrise transponert = A.transponere();
        transponert.skrivUt();
    }
}