package Oppg1;
public class Arrangement implements Comparable<Arrangement>{
    
    private final String name;
    private final String location;
    private final String host;
    private final String type;
    private final int num;
    private final long time;

    //konstruktør
    Arrangement(String name, String location,
     String host, String type, int num, long time){
        this.name = name;
        this.location = location;
        this.host = host;
        this.type = type;
        this.num = num;
        this.time = time;
    } 

    //gettere
    public String getName(){return this.name;}
    public String getLocation(){return this.location;}
    public String getHost(){return this.host;}
    public String getType(){return this.type;}
    public int getNum(){return this.num;}
    public long getTime(){return this.time;}

    @Override
    public String toString(){
        return (String) "name: " + name + " | location: " + location + " | host: " + host + " | type: " + type + " | num: " + num + " | time: " + time; 
    }

    @Override
    public int compareTo(Arrangement other) {
        return Long.compare(this.time, other.time);
    }
}
