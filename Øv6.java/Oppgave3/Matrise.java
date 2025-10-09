package Oppgave3;

public final class Matrise {
    private final int[][] data;
    private final int rad;
    private final int col;

    public Matrise(int[][] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Matrisen kan ikke være tom");
        }
        this.rad = data.length;
        this.col = data[0].length;

        this.data = new int[rad][col];

        for (int i = 0; i < rad; i++) {
            if (data[i].length != col) {
                throw new IllegalArgumentException("Alle kolonner må være samme lengde");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, col);
        }
    } 

    public Matrise addere(Matrise annen) {
        if (annen == null || this.rad != annen.rad || this.col != annen.col) {
            return null;
        }

        int[][] resultat = new int[rad][col];
        for (int i = 0; i < rad; i++) {
            for (int j = 0; j < col; j++) {
                resultat[i][j] = this.data[i][j] + annen.data[i][j];
            }
        }
        
        return new Matrise(resultat);
    }

    public Matrise multiplisere(Matrise annen) {
        if (annen == null || this.col != annen.rad) {
            return null;
        }
        
        int[][] resultat = new int[this.rad][annen.col];
        
        for (int i = 0; i < this.rad; i++) {
            for (int j = 0; j < annen.col; j++) {
                int sum = 0;
                for (int k = 0; k < this.col; k++) {
                    sum += this.data[i][k] * annen.data[k][j];
                }
                resultat[i][j] = sum;
            }
        }
        
        return new Matrise(resultat);
    }

    public Matrise transponere() {
        int[][] resultat = new int[col][rad];
        
        for (int i = 0; i < rad; i++) {
            for (int j = 0; j < col; j++) {
                resultat[j][i] = this.data[i][j];
            }
        }
        
        return new Matrise(resultat);
    }

    public void skrivUt() {
        for (int i = 0; i < rad; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getData() {
        int[][] kopi = new int[rad][col];
        for (int i = 0; i < rad; i++) {
            System.arraycopy(data[i], 0, kopi[i], 0, col);
        }
        return kopi;
    }

    public int getRad() {
        return rad;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < rad; i++) {        
            for (int j = 0; j < col; j++) { 
                sb.append(data[i][j]);           
                if (j < col - 1) {          
                    sb.append("\t");
                }
            }
            if (i < rad - 1) {                 
                sb.append("\n");
            }
        }
        return sb.toString();                  
    }
}