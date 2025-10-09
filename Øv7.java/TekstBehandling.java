public class TekstBehandling {

    private final String text;

    public TekstBehandling(String text){
        this.text = text;
    }

    public int countWord(){
        String[] word = text.split("\\s+");

        return word.length; 
    }

    public double avrgWord(){
        String[] word = text.split("\\s+");

        int allCharLen = 0;
        int numWord = 0;

        for (String ord : word){
            allCharLen += ord.length();
            numWord++;
        }

        return (double) allCharLen/numWord;
    }

    public double avrgSent(){
        String[] sentences = text.split("[.!?]");

        int allCharLen = 0;
        int numSentence = 0;

        for (String sentence : sentences){
            allCharLen += sentence.length();
            numSentence++;
        }

        return (double) allCharLen/numSentence;
    }

    public String rep(String find, String replace){
        
        return text.replaceAll("\\b" + find + "\\b", replace);
    }

    public String getText(){
        return text;
    }

    public String getUpperText(){
         return text.toUpperCase();
    }


}
