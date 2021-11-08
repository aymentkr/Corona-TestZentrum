
public class Anschrift{
    private String strasse, Stadt,Postleitzahl;
    private int hausnummer;
    public Anschrift(){
        strasse = Stadt = Postleitzahl = "";
        hausnummer = 0;
    }

 public void setStrasse(String str)
   {
      strasse = str;
   }
    public void setHnum(int h)
   {
      hausnummer = h;
   }
   public void setStadt(String st)
   {
      Stadt = st;
   }
   public String getStadt(){
      return Stadt;
   }
   public void setPLZ(String plZ)
   {
      Postleitzahl = plZ;
   }
   public String toString(){
       return strasse + " " + hausnummer + "\n" + Postleitzahl +" " + hausnummer;
   }
}
