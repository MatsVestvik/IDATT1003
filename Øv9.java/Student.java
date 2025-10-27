public class Student{
    private final String navn;
    private int antOppg;


    Student (String navn){
        this.navn = navn;
        this.antOppg = 0;
    }
    Student (String navn, int antOppg){
        this.navn = navn;
        this.antOppg = antOppg;
    }

    //getMethods
    public String getNavn(){return this.navn;}
    public int getAntOppg(){return this.antOppg;}

    //methods
    public void okAntOppg(int amount){
        this.antOppg += amount;
    }

    @Override
    public String toString(){
        return (String) this.navn + ", " + this.antOppg;
    }
}