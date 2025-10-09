public class TidTilSekunder {
    public static void main(String[] args) {
        // Tiden definert som variabel (i formatet "timer.minutter.sekunder")
        String tid = "2.59.59";
        
        // Deler opp strengen
        String[] deler = tid.split("\\.");
        
        // Konverterer til tall
        int timer = Integer.parseInt(deler[0]);
        int minutter = Integer.parseInt(deler[1]);
        int sekunder = Integer.parseInt(deler[2]);
        
        // Regner ut totalt antall sekunder
        int totalSekunder = timer * 3600 + minutter * 60 + sekunder;
        
        // Skriver ut resultatet
        System.out.println(tid + " = " + totalSekunder + " sekunder");
    }
}

