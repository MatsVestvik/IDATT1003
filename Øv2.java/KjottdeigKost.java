/*Lag et program som hjelper oss i forhold til følgende problemstilling: Kjøttdeig av merke A
koster kr 35,90 for 450 gram, mens kjøttdeig av merke B koster kr 39,50 for 500 gram.
Hvilket merke er billigst? */

public class KjottdeigKost{
    public static void main(String[] args){
        double prisA = 35.90;
        double vektA = 450.0;
        double prisB = 39.50;
        double vektB = 500.0;

        double prisPerKgA = (prisA / vektA) * 1000;
        double prisPerKgB = (prisB / vektB) * 1000;

        if (prisPerKgA < prisPerKgB){
            System.out.println("Kjøttdeig merke A er billigst med en pris på: " + String.format("%.2f", prisPerKgA) + " kr/kg");
        }
        else if (prisPerKgB < prisPerKgA){
            System.out.println("Kjøttdeig merke B er billigst med en pris på: " + String.format("%.2f", prisPerKgB) + " kr/kg");
        }
        else {
            System.out.println("Begge merkene har samme pris på: " + String.format("%.2f", prisPerKgA) + " kr/kg");
        }

    }
}