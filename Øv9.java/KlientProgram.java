import java.util.Scanner;

public class KlientProgram{
    public static boolean run = true;
    private static Oppgaveoversikt oversikt = new Oppgaveoversikt();
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
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("""
                        enter name of student:
                        """);
                String navn = scanner.nextLine();
                boolean success = oversikt.registrerNyStudent(navn);
                if (success) {
                    System.out.println("Student " + navn + " registered successfully!");
                } else {
                    System.out.println("Student " + navn + " already exists!");
                }    
            }
            else if (choice == 2){
                System.out.println("""
                        enter the name of the student
                        """);
                String navn = scanner.nextLine();
                int antOppgaver = oversikt.finnAntOppgaver(navn);
                if (antOppgaver == -1) {
                    System.out.println("Student " + navn + " not found!");
                } else {
                    System.out.println(navn + " has " + antOppgaver + " tasks approved");
                    System.out.println("Enter the amount of tasks you would like to increase:");
                    int amount = scanner.nextInt();
                    scanner.nextLine(); // Konsumer newline
                    
                    boolean success = oversikt.okAntOppgForStudent(navn, amount);
                    if (success) {
                        System.out.println("Successfully increased tasks for " + navn);
                    } else {
                        System.out.println("Failed to increase tasks for " + navn);
                    }
                }
            }
            else if (choice == 3){
                System.out.println(oversikt.toString());
                
            }
            else{
                System.out.println("invalid choice");
                run = false;
            }
        }
        
        scanner.close();
    }
}