

public class Kunde {
    private static int idnummer = 0;
    private String name; 
    private int age ;
    private String email;
    private String ausweisnummer;
    private String staatsangehörigkeit;
    public Anschrift a = new Anschrift();
    
    
    public Kunde(){
        
    }
    public Kunde(String name,int age,String email,String ausweisnummer,String staatsangehörigkeit){
        this.name = name;
        this.age = age; 
        this.email=email;
        this.ausweisnummer= ausweisnummer;
        this.staatsangehörigkeit = staatsangehörigkeit;
        idnummer++;
       }
       
    public int getAge(){
        return age;
    }

       public String toString() {
        return "kunde "+this.idnummer+"\n"+name+"\n" +this.a+
                "\nEmail : "+this.email;
    }
   }

