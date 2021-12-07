
public class COVID19_Test
{
    private int id;
    private String name; 
    private double preis;
    private int dauer_Std ;
    private char ergebnis = '-';
    
    
    public COVID19_Test(int id ,String name,double preis,int dauer_Std) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.dauer_Std = dauer_Std;
    }


    public void positivErgebnis(){
        ergebnis = '+';
    }
    public char getErgebnis(){
        return ergebnis;
    }
    public int getId(){
        return id;
    }
    public double getPreis(){
        return preis;
    }
    public String toString() {
        return name + " Preis = "+preis+ " dauer_Std = "+dauer_Std;
    }
}
