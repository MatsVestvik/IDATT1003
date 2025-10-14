public class test {
    public static void main(String[] args) {
        Student student1 = new Student("Ola");
        Student student2 = new Student("Kari", 3);
        
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        

        student1.okAntOppg(2);
        student2.okAntOppg(1);
        

        System.out.println("Etter økning:");
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        
        System.out.println("\nGet-metoder:");
        System.out.println(student1.getNavn() + " har " + student1.getAntOppg() + " oppgaver");
        System.out.println(student2.getNavn() + " har " + student2.getAntOppg() + " oppgaver");
    }
}