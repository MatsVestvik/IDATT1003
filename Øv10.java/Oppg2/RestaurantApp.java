import java.util.Arrays;
import java.util.List;

public class RestaurantApp {
    public static void main(String[] args) {
        MenyRegister register = new MenyRegister();
        
        // Registrer noen retter
        register.registrerRett("Cæsarsalat", "forrett", 120, "Salat med dressing og krutonger");
        register.registrerRett("Laks", "hovedrett", 280, "Ovnsbakt laks med sitron");
        register.registrerRett("Biff", "hovedrett", 320, "Oksefilet med pepper saus");
        register.registrerRett("Panna Cotta", "dessert", 110, "Kremet dessert med bær");
        register.registrerRett("Suppe", "forrett", 90, "Dagens suppe");
        
        // Finn retter
        System.out.println("Alle forretter:");
        register.finnRetterAvType("forrett").forEach(System.out::println);
        
        // Registrer menyer
        List<String> meny1Retter = Arrays.asList("Cæsarsalat", "Laks", "Panna Cotta");
        register.registrerMeny("Laksemeny", meny1Retter);
        
        List<String> meny2Retter = Arrays.asList("Suppe", "Biff", "Panna Cotta");
        register.registrerMeny("Biffemeny", meny2Retter);
        
        // Finn menyer i prisintervall
        System.out.println("\nMenyer mellom 400 og 600 kr:");
        register.finnMenyerIPrisintervall(400, 600).forEach(System.out::println);
    }
}