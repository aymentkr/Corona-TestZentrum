import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Console{
  public static Scanner sc = new Scanner(System.in);
  
  public void alert(String str){
      JOptionPane.showMessageDialog(null,str);
  }
  static boolean controlEmail (String email){   
        String regex = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);        
        return m.matches();
    } 
    
    public static boolean controlTestGratis (Kunde k,char c){
        return ( c == 'j' || k.getAge()<18);  
    }
    
    public Kunde read_data_kunde (){
        String  name,email,ausweisnummer, nationality , str , Stadt,plz ; 
        int age,hausnummer ;

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
       k.a = new Anschrift(str,hausnummer,plz,Stadt);
    return k;
    }
    
    
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
}