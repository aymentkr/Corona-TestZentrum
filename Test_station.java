

public class Test_station
{
    private String name; 
     public Anschrift a = new Anschrift();

    public Test_station(String name){
        this.name = name;
    }
    public String toString(){
        return name + " " + a;
    }

 
}
