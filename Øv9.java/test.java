public class test {
    public static void main(String[] args){
        Student student = new Student("Mats", 3); 

        student.okAntOppg(4);


        System.out.println(student.getAntOppg() + student.getNavn());
        System.out.println(student.toString());
    }
}
