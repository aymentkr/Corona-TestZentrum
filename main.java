import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

class main {
    
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



    public static void main(String[] args) {
        String name,email,ausweisnummer, nationality , str , Stadt,plz ; 
        int age,hausnummer ;
        boolean gratis = false;

        // test lists
        COVID19_Test T1 = new COVID19_Test("PCR-Test",50,36);
        COVID19_Test T2 = new COVID19_Test("Antigen-Schnell-Test",9.90,48);
        COVID19_Test T3 = new COVID19_Test ("Antikörper-Test",30,0);

        // Teststation lists for
        Test_station TS1 = new Test_station ("Testzentrum Save & Protect Virchow Klinikum");
        TS1.a = addAddress("Virchowstraße",18,"08371","Glauchau");
        Test_station TS2 = new Test_station ("Heinrich-Braun-Klinikum");
        TS2.a = addAddress("Karl-Keil-Straße",35,"08056","Zwickau");
        ArrayList <Test_station> Test_stations= new ArrayList <>(); 
        Test_stations.add(TS1);
        Test_stations.add(TS2);

       
        
        Scanner sc=new Scanner(System.in);
        // menu
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
        System.out.println("10/ Sind Sie Schwangere oder Studierende aus dem Ausland, die mit anderen Impfstofefen geimpft wurden? j/n");
        char c = sc.next().charAt(0);
        if ( c == 'j' || age<18) gratis =!gratis; 
        
    System.out.println("Wählen sie ihre covid-19 test:");
    System.out.println("1- "+T1);
    System.out.println("2- "+T2);
    System.out.println("3- "+T3);
    c = sc.next().charAt(0);
    
        
        
       // kunde 
       Kunde k = new Kunde (name,age,email,ausweisnummer,nationality);
        k.a = addAddress(str,hausnummer,plz,Stadt);
       
       // Termin 
       
    int count = 0;         
      while (Test_stations.size() > count ) {
          if (Test_stations.get(count).a.getStadt().toUpperCase()== k.a.getStadt().toUpperCase()){
            Termin TR = new Termin (k,Test_stations.get(count));
            System.out.println(TR);
               if (c == '2' && gratis) System.out.println("COVID-19 Test ist kostenlos für sie!" );
           else {
        if (c == '1') System.out.println("Du musst "+T1.getPreis()+" Euro bezahlen");
        if (c == '2') System.out.println("Du musst "+T2.getPreis()+" Euro bezahlen");
        if (c == '3') System.out.println("Du musst "+T3.getPreis()+" Euro bezahlen");
           }
          }
         count++;
      }

      if (count > Test_stations.size()) System.out.println("Wir haben leider kein Testzentrum für sie gefunden");


       

        
       }
       
    }
    



