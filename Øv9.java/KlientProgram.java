import java.util.Scanner;

public class KlientProgram{
    public static boolean run = true;
    private static Oppgaveoversikt oversikt;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (run == true){
            System.out.println("""
                Choose an option:
                1. register new student
                2. increase task for student
                3. print table
                """);
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("""
                        enter name of student:
                        """);
                oversikt.registrerNyStudent(scanner.nextLine());        
            }
            else if (choice == 2){
                System.out.println("""
                        enter the name of the student
                        """);
                String navn = scanner.nextLine();
                System.out.println(navn + " has " + oversikt.finnAntOppgaver(navn) +" task approved");
                System.out.println("""
                        enter the amount of task you would like to increase
                        """);
                int amount = scanner.nextInt();

                oversikt.okAntOppgForStudent(navn, amount);
            }
            else if (choice == 3){
                oversikt.toString();
            }
            else{
                System.out.println("invalid choice");
                run = false;
            }
        }
        
        scanner.close();
    }
}