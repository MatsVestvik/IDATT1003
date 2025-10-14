public class test {
    public static void main(String[] args){
        Oppgaveoversikt oppgaveoversikt = new Oppgaveoversikt(4);
        
        oppgaveoversikt.registrerNyStudent("Mats");
        oppgaveoversikt.registrerNyStudent("Birgitte");
        oppgaveoversikt.okAntOppgForStudent("Mats", 30);
        System.out.println(oppgaveoversikt.toString());

        



    }
}
