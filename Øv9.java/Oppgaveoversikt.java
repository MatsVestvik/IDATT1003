public class Oppgaveoversikt{
    private Student[] studenter;
    private int antStud = 0;
    
    Oppgaveoversikt(Student student){
        this.studenter[antStud] = student;
        antStud += 1;
    }

    
}