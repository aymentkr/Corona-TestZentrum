
public class COVID19_Test
{
    private String name; 
    private double preis;
    private int dauer_Std ;
    private char ergebnis = '-';

  
    public COVID19_Test(String name,double preis,int dauer_Std) {
        this.name = name;
        this.preis = preis;
        this.dauer_Std = dauer_Std;
    }


    public void positivErgebnis(){
        ergebnis = '+';
    }
    public double getPreis(){
        return preis;
    }
    public String toString() {
        return name + " Preis = "+preis+ " dauer_Std = "+dauer_Std;
    }
}
