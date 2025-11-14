import java.util.Scanner;

public class test {

    static boolean running = true;
    static Scanner scanner;
    static TomtRegister reg;
    public static void main(String[] args){

        reg = new TomtRegister();
        scanner = new Scanner(System.in);

        reg.addTomt("Gloppen", 1445, 77, 631, "null", 1017.6, "Jens Olsen");
        reg.addTomt("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        reg.addTomt("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        reg.addTomt("Gloppen", 1445, 74, 188, "null", 1457.2, "Karl Ove Bråten");
        reg.addTomt("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård");

        while (running){
            System.out.println("""
                    Choose:
                    1. Add property
                    2. print all properties
                    3. search property
                    4. avrg area of all
                    5. search gaardnr
                    6. quit
                    """);
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1 -> addPropertyMenu();
                case 2 -> reg.getAll();
                case 3 -> searchPropertyMenu();
                case 4 -> System.out.println(reg.getAvrgArea());
                case 5 -> searchknrMenu();
                case 6 -> running = false;
                default -> {}
            }
        }
        scanner.close();
    }

    static void addPropertyMenu(){
        scanner = new Scanner(System.in);
        System.out.print("Enter kommuneNavn: ");
        String kommuneNavn = scanner.nextLine();
        System.out.print("Enter kommuneNr: ");
        int kommuneNr = scanner.nextInt();
        System.out.print("Enter gaardsNr: ");
        int gaardsNrNr = scanner.nextInt();
        System.out.print("Enter bruksNr: ");
        int bruksNr = scanner.nextInt();
        System.out.print("Enter bruksNavn: ");
        String bruksNavn = scanner.nextLine();
        System.out.print("Enter areal: ");
        double areal = scanner.nextDouble();
        System.out.print("Enter eier: ");
        String eier = scanner.nextLine();

        reg.addTomt(kommuneNavn, kommuneNr, gaardsNrNr, bruksNr, bruksNavn, areal, eier);

    }

    static void searchPropertyMenu(){
        scanner = new Scanner(System.in);
        System.out.print("Enter unikID (eks: 1445-77/631): ");
        String unikID = scanner.nextLine();

        reg.getTomt(unikID);
    }
    
    static void searchknrMenu(){
        scanner = new Scanner(System.in);
        System.out.print("Enter kommunenr (eks: 77): ");
        int knr = scanner.nextInt();
        reg.getAllKommuneNr(knr);
    }
}
