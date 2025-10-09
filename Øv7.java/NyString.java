public class NyString{

    private final String tekst;
    

    public NyString(String tekst){
        this.tekst = tekst;
    }

    public String forkort(){
        String[] ord = tekst.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        

        for (String word : ord) {
            if (!word.isEmpty()) {  
                stringBuilder.append(word.charAt(0));  
            }
        }

        return stringBuilder.toString();
    }

    public String removeChar(char car){
        int currentIndex = 0;
        int foundIndex;
        StringBuilder stringBuilder = new StringBuilder();

        while ((foundIndex = tekst.indexOf(car, currentIndex)) != -1) {
            stringBuilder.append(tekst.substring(currentIndex, foundIndex));

            currentIndex = foundIndex + 1;
        }

        stringBuilder.append(tekst.substring(currentIndex));

        return stringBuilder.toString();
    }
    
}