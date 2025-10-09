public class test {
    
    public static void main(String[] args){

        NyString nyString = new NyString("her er en eksempel tekst");

        System.out.println(nyString.forkort());
        System.out.println(nyString.removeChar('k'));


        TekstBehandling tekstBehandling = new TekstBehandling(
        """
        her er en eksempel tekst. 
        med en ekstra setnign fro å teste det også? 
        med enda en.
        her er en ekstra også for gøyååååå!
        """);
        
        System.out.println(tekstBehandling.countWord());
        System.out.println(tekstBehandling.avrgWord());
        System.out.println(tekstBehandling.avrgSent());
        System.out.println(tekstBehandling.rep("her", "dette"));
        System.out.println(tekstBehandling.getText());
        System.out.println(tekstBehandling.getUpperText());
    }
}
