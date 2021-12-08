import java.util.Calendar;
import java.time.LocalDate;
import java.util.Random;
import java.time.LocalDateTime;

public class Termin extends Console{
     Kunde k;
     Test_station ts ;
     COVID19_Test ct;
     private double gesamtpreis = 0;
     LocalDateTime Uhrzeit_Datum ;
     
    public Termin(Kunde k,Test_station ts,COVID19_Test ct) {
      this.k = k;
      this.ts = ts;
      this.ct = ct;
    }
    
    public void createAppointment (){
        System.out.println("10/ Sind Sie Schwangere oder Studierende aus dem Ausland, die mit anderen Impfstofefen geimpft wurden? j/n");
        char c = sc.next().charAt(0); 
        clearConsole();
        setDate();
        System.out.println(this);
          if (ct.getId() == 2 && controlTestGratis(k,c)) System.out.println("COVID-19 Test ist kostenlos für sie!" );  
          else{
           setPreis(ct.getPreis());
           System.out.println("Du musst "+gesamtpreis+" Euro bezahlen");           
       }
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
    return "Der Termin wäre am " + Uhrzeit_Datum + " in " +ct + " \nfür :" + k;
    }

}
