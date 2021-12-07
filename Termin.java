import java.util.Calendar;
import java.time.LocalDate;
import java.util.Random;
import java.time.LocalDateTime;

public class Termin {
     Kunde k;
     Test_station t ;
     private double gesamtpreis = 0;
     LocalDateTime Uhrzeit_Datum ;
     
    public Termin(Kunde k,Test_station t) {
      this.k = k;
      this.t = t;
    }
    
    public void setPreis(double preis){
        gesamtpreis = preis;
    }
    public double getPreis(){
        return gesamtpreis;
    }
    public void setDate(){
       Random randomN = new Random();
       LocalDateTime date = LocalDateTime.now().withHour(randomN.nextInt(17)+7).plusDays(randomN.nextInt(15) + 1);
       Uhrzeit_Datum = date;    
    }
    public String toString(){
    return "Der Termin wäre am " + Uhrzeit_Datum + " in " +t + " \nfür :" + k;
    }

}
