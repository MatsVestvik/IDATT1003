/*
Lag en klasse Valuta med minst en konstruktør. Klassen skal ha metoder for å regne fra og til
norske kroner.
Lag et klientprogram som oppretter minst tre objekter som representerer forskjellige valutaer.
Brukeren skal få tilbud om å regne om flere ulike beløp i de forskjellige valutaene til norske
kroner.
Programmet må altså presentere en meny for brukeren. Den kan for eksempel se sånn ut:
Velg valuta:
1: dollar
2: euro
3: svenske kroner
4: avslutt
Brukeren skriver inn ett av tallene 1, 2 eller 3 (eller 4 for avslutt). Dette skal styre
programflyten slik at riktig valutaobjekt blir brukt.
*/

public class Valuta {

    /* 
   private float mengde;
   private float forholdUnderNok;
   */

   private String navn;
   
    public Valuta(String navn){
        this.navn = navn;
    }
    
    public float valutaTilNok(float mengde, float forholdUnderNok){
        return forholdUnderNok*mengde;
    }

    public float valutaFraNok(float mengde, float forholdUnderNok){
        return mengde/forholdUnderNok;
    }


}