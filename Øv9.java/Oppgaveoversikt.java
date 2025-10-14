public class Oppgaveoversikt {
    private Student[] studenter;  
    private int antStud = 0;      
    
    //Konstuktør
    public Oppgaveoversikt() {
        this.studenter = new Student[10];
    }
    public Oppgaveoversikt(int maksAntallStud) {
        this.studenter = new Student[maksAntallStud];
    }

    //Metoder
    
    //FInn antall oppgaver
    public int finnAntOppgaver(String navn){
        for (int i = 0; i<antStud; i++){
            if(studenter[i].getNavn().equals(navn)){
                return studenter[i].getAntOppg();
            }
        }
        return -1;
    }

    //registrer ny student
    public boolean registrerNyStudent(String navn) {
        
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                return false; 
            }
        }
        if (antStud >= studenter.length){
            return false;
        }

        studenter[antStud] = new Student(navn);
        antStud++;
        return true;
    }

    //Øk antall oppgaver godkjent for en student
    public boolean okAntOppgForStudent(String navn, int okning){
        for (int i = 0; i < antStud; i++){
            if(studenter[i].getNavn().equals(navn)){
                studenter[i].okAntOppg(okning);
                return true;
            }
        }
        return false;
    }
    
    //getters
    public int getAntStud() {
        return antStud;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Oppgaveoversikt - Antall studenter: ").append(antStud).append("\n");
        for (int i = 0; i < antStud; i++) {
            sb.append(studenter[i].toString()).append("\n");
        }
        return sb.toString();
    }

    
}