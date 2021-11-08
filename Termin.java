import java.util.Date;  
import java.util.Calendar;
import java.time.LocalDate;

public class Termin {
     Kunde k;
     Test_station t ;

    public Termin(Kunde k,Test_station t) {
      this.k = k;
      this.t = t;
    }


    public String toString(){
   Date input = new Date();
   Calendar cal = Calendar.getInstance();
   cal.setTime(input);
   LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH) + 1,
        cal.get(Calendar.DAY_OF_MONTH));
   
    return "Der Termin wäre am " +date + "in " +t + "für :" + k;
    }

}
