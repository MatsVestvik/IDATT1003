import java.util.Scanner;

public class Test{ 
    static Scanner scanner;
    static MenyRegister register;
    static boolean running = true;
    public static void main(String[] args){
        register = new MenyRegister();

        register.addDish("Carbonara","Dinner","null", 15.99);
        register.addDish("Bolognese", "Dinner", "null", 10.49);
        register.addDish("IceCream", "Dessert", "null", 5.99);
        register.addDish("English Breakfast", "Breakfast","null", 10.99);

        register.addMeny("Mats's Resturant");
        register.addDTM("Mats's Resturant","Carbonara");
        register.addDTM("Mats's Resturant","IceCream");
        register.addDTM("Mats's Resturant","English Breakfast");

        register.addMeny("Birgitte's Resturant");
        register.addDTM("Birgitte's Resturant","Carbonara");
        
        Scanner scanner = new Scanner(System.in);
        while(running){
            System.out.println("""
                    Choose:
                    1. Print Register
                    2. Find all type
                    3. Find all in price
                    4. exit
                    """);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> register.printRegister();
                case 2 -> case2();
                case 3 -> case3();
                case 4 -> running = false;
                default -> {}
            }
        } 

        scanner.close();
    }

    public static void case2(){
        System.out.println("Enter a type (Dinner, Dessert...):");
        scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        register.findRettType(type);
    }

    public static void case3(){
        scanner = new Scanner(System.in);
        System.out.print("Enter min price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter max price: ");
        double max = scanner.nextDouble();

        register.finnMenyerInnenforPrisintervall(min, max);
    }
} 