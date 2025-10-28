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
                    4. Add Dish
                    5. Add new Menu
                    6. Add dish to menu
                    7. exit
                    """);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> register.printRegister();
                case 2 -> case2();
                case 3 -> case3();
                case 4 -> case4();
                case 5 -> case5();
                case 6 -> case6();
                case 7 -> running = false;
                default -> {}
            }
        } 

        scanner.close();
    }

    public static void case2(){
        System.out.print("Enter a type (Dinner, Dessert...): ");
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
    public static void case4(){
        scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter reciepie: ");
        String reciepe = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        register.addDish(name, type, reciepe, price);
    }

    public static void case5(){
        scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        register.addMeny(name);
    }

    public static void case6(){
        scanner = new Scanner(System.in);
        System.out.print("Enter menu: ");
        String menu = scanner.nextLine();
        System.out.print("Enter Dish: ");
        String dish = scanner.nextLine();
        register.addDTM(menu, dish);
        
    }
} 