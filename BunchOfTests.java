import java.util.ArrayList;

public class BunchOfTests extends Console{
    ArrayList <COVID19_Test> COVID19_Tests= new ArrayList <>();
    
    public BunchOfTests(){
        COVID19_Test T1 = new COVID19_Test(1,"PCR-Test",50,36);
        COVID19_Test T2 = new COVID19_Test(2,"Antigen-Schnell-Test",9.90,48);
        COVID19_Test T3 = new COVID19_Test (3,"Antikörper-Test",30,0);
        COVID19_Tests.add(T1);
        COVID19_Tests.add(T2);
        COVID19_Tests.add(T3);
    }
    
     public COVID19_Test chooseTest (Kunde k){
        try {
        System.out.println("Wählen sie ihre covid-19 test:");
        COVID19_Tests.forEach( (t) -> {System.out.println(t.getId()+" :"+t); } );
        int i = sc.nextInt();
        return COVID19_Tests.get(i-1);
    }
        catch(Exception e){
            alert("Sie haben falsche Informationen eingegeben. Bitte versuche es erneut.");
            return null;
        }
}
}


