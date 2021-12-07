import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

class main {
    
    
    static Scanner sc=new Scanner(System.in);
    static String  name,email,ausweisnummer, nationality , str , Stadt,plz ; 
    static int age,hausnummer ;
    
    public final static void clearConsole()  {  
        System.out.print('\u000C');
        /*try  {  
      final String os = System.getProperty("os.name");  
      if (os.contains("Windows"))  {  
          Runtime.getRuntime().exec("cls");  
        }  else  {  
            Runtime.getRuntime().exec("clear");  
        }  
    }  catch (final Exception e)  {  
        e.printStackTrace();  }  */
    }
    
    static boolean controlEmail (String email){   
        String regex = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);        
        return m.matches();
    } 
    public static Anschrift addAddress ( String str, int hausnummer,String plz,String Stadt){ 
        Anschrift a = new Anschrift();
        a.setStrasse(str);
        a.setHnum(hausnummer);
        a.setPLZ(plz);
        a.setStadt(Stadt);
        return a;
    }
    public static boolean controlTestGratis (Kunde k,char c){
        return ( c == 'j' || k.getAge()<18);  
    }
    
    public static Kunde lire_data_kunde (){
        
        System.out.println("1- Name?");
        name = sc.nextLine();
        System.out.println("2- Age?");
        age = sc.nextInt();
        System.out.println("3- Email?");
        do {
        email = sc.nextLine();
        } while (!controlEmail(email));
        System.out.println("4- Ausweisnummer?");
        ausweisnummer = sc.nextLine();
        System.out.println("5- Staatsangehörigkeit?");
        nationality = sc.nextLine();
        System.out.println("6- Strasse?");
        str = sc.nextLine();
        System.out.println("7- Hausnummer?");
        hausnummer = sc.nextInt();
        System.out.println("8- Postleitzahl?");
        do {
            plz = sc.nextLine();
        } while (plz.length() != 5);
        System.out.println("9- Stadt?");
        Stadt = sc.nextLine();
       Kunde k = new Kunde (name,age,email,ausweisnummer,nationality);
        k.a = addAddress(str,hausnummer,plz,Stadt);
        return k ;
    }
    
    public static void chooseTest (Kunde k ,ArrayList <COVID19_Test> COVID19_Tests){
        System.out.println("Wählen sie ihre covid-19 test:");
        COVID19_Tests.forEach( (t) -> {System.out.println(t.getId()+" :"+t); } );
        char c = sc.next().charAt(0);
        
        switch (c) {
    case '1' :  k.setTest(COVID19_Tests.get(0)); break;
    case '2' : k.setTest(COVID19_Tests.get(1)); break;
    case '3' : k.setTest(COVID19_Tests.get(2)); break;
    default  : System.out.println("Sie haben falsche Informationen eingegeben. Bitte versuche es erneut."); System.exit(0);
        };
    }
    
    public static void createAppointment (Kunde k,ArrayList <Test_station> Test_stations){
        System.out.println("10/ Sind Sie Schwangere oder Studierende aus dem Ausland, die mit anderen Impfstofefen geimpft wurden? j/n");
        char c = sc.next().charAt(0); 
        int count = 0;         
      while (Test_stations.size() > count && !Test_stations.get(count).a.getStadt().toUpperCase().equals(k.a.getStadt().toUpperCase())) {
         count++;
      }
      clearConsole();
      if (count < Test_stations.size()) {
          Termin TR = new Termin (k,Test_stations.get(count));
          TR.setDate();
          System.out.println(TR);
          if (k.t.getId() == 2 && controlTestGratis(k,c)) System.out.println("COVID-19 Test ist kostenlos für sie!" );  
          else{
           TR.setPreis(k.t.getPreis());
           System.out.println("Du musst "+TR.getPreis()+" Euro bezahlen");
        }
         }
         else  System.out.println("Wir haben leider kein Testzentrum für sie gefunden");  
           
       }
        
    
    
    
    
    

    public static void main(String[] args) {
        
        // covid-19 tests lists
        
        COVID19_Test T1 = new COVID19_Test(1,"PCR-Test",50,36);
        COVID19_Test T2 = new COVID19_Test(2,"Antigen-Schnell-Test",9.90,48);
        COVID19_Test T3 = new COVID19_Test (3,"Antikörper-Test",30,0);
        ArrayList <COVID19_Test> COVID19_Tests= new ArrayList <>(); 
        COVID19_Tests.add(T1);
        COVID19_Tests.add(T2);
        COVID19_Tests.add(T3);

        // Teststation lists 
        Test_station TS1 = new Test_station ("Testzentrum Save & Protect Virchow Klinikum",15);
        TS1.a = addAddress("Virchowstraße",18,"08371","Glauchau");
        Test_station TS2 = new Test_station ("Heinrich-Braun-Klinikum",10);
        TS2.a = addAddress("Karl-Keil-Straße",35,"08056","Zwickau");
        Test_station TS3 = new Test_station ("Schnelltestzentrum Zwickau-Globus",20);
        TS3.a = addAddress("Äußere Schneeberger Str.", 100, "08056", "Zwickau");
        
        
        ArrayList <Test_station> Test_stations= new ArrayList <>(); 
        Test_stations.add(TS1);
        Test_stations.add(TS2);
        Test_stations.add(TS3);
        
        // read data
        Kunde k = lire_data_kunde(); 
        // choose your test
        chooseTest(k,COVID19_Tests);
        // Termin 
        createAppointment(k,Test_stations);
        
       }
       
    }
    



