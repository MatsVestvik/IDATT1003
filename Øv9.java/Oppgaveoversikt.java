public class Oppgaveoversikt {
    private Student[] studenter;
    private int antStud = 0;
    
    public Oppgaveoversikt(int maksAntallStudenter) {
        studenter = new Student[maksAntallStudenter];
        antStud = 0;
    }
    
    // Finn antall studenter registrert
    public int getAntallStudenter() {
        return antStud;
    }
    
    // Finn antall oppgaver for en bestemt student
    public int finnAntOppgaver(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1; // Student ikke funnet
    }
    
    // Registrer en ny student
    public boolean registrerNyStudent(String navn) {
        // Sjekk om navnet allerede finnes (entydig)
        if (finnStudentIndex(navn) != -1) {
            System.out.println("Student med navn '" + navn + "' finnes allerede!");
            return false;
        }
        
        // Sjekk om det er plass
        if (antStud >= studenter.length) {
            System.out.println("Ikke plass til flere studenter!");
            return false;
        }
        
        studenter[antStud] = new Student(navn);
        antStud++;
        return true;
    }
    
    // Øk antall oppgaver for en bestemt student
    public boolean økAntOppgForStudent(String navn, int økning) {
        int index = finnStudentIndex(navn);
        if (index != -1) {
            studenter[index].økAntOppg(økning);
            return true;
        }
        return false; // Student ikke funnet
    }
    
    // Hjelpemetode for å finne student index
    private int finnStudentIndex(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== OPPGAVEOVERSIKT ===\n");
        sb.append("Antall studenter: ").append(antStud).append("\n");
        for (int i = 0; i < antStud; i++) {
            sb.append(studenter[i].toString()).append("\n");
        }
        return sb.toString();
    }
    
    // Ekstra metode for å få tilgang til en spesifikk student
    public Student getStudent(String navn) {
        int index = finnStudentIndex(navn);
        if (index != -1) {
            return studenter[index];
        }
        return null;
    }
}