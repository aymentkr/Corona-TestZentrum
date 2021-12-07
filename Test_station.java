

public class Test_station
{
    private String name; 
    public Anschrift a = new Anschrift();
    private int Mitarbeiter_Nbr;
    
    public Test_station(String name, int Mitarbeiter_Nbr){
        this.name = name;
        this.Mitarbeiter_Nbr = Mitarbeiter_Nbr;
    }
    public String toString(){
        return name + " " + a;
    }

 
}
