public class Rett{
    private String name;
    private String type;
    private String oppskrift;
    private double price;

    Rett(String name, String type, String oppskrift, double price){
        this.name = name;
        this.type = type;
        this.oppskrift = oppskrift;
        this.price = price;
    }

    public String getName() {return name;}
    public String getType() {return type;}
    public String getOppskrift() {return oppskrift;}
    public double getPrice() {return price;}

    @Override
    public String toString(){
        return String.format("| type: %-5s |  name: %-5s  | price: %-5s kr |",
         this.type, this.name, this.price);
    }
}