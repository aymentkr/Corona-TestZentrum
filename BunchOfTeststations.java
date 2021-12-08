import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class BunchOfTeststations extends Console{
    ArrayList <Test_station> Test_stations= new ArrayList <>(); 
    private Random randomGenerator = new Random();

    public BunchOfTeststations(){
        Test_station TS1 = new Test_station ("Testzentrum Save & Protect Virchow Klinikum",15);
        TS1.a = new Anschrift("Virchowstraße",18,"08371","Glauchau");
        Test_station TS2 = new Test_station ("Heinrich-Braun-Klinikum",10);
        TS2.a = new Anschrift("Karl-Keil-Straße",35,"08056","Zwickau");
        Test_station TS3 = new Test_station ("Schnelltestzentrum Zwickau-Globus",20);
        TS3.a = new Anschrift("Äußere Schneeberger Str.", 100, "08056", "Zwickau");
        
        Test_stations.add(TS1);
        Test_stations.add(TS2);
        Test_stations.add(TS3);
    }
    public Test_station find_TestStation (Kunde k){
        
        List<Test_station>TS = Test_stations.stream()
        .filter(t -> t.a.getStadt().toUpperCase().equals(k.a.getStadt().toUpperCase()))
        .collect(Collectors.toList());

      if (TS.isEmpty()) {
          return null;
      }
      else {
          int index = randomGenerator.nextInt(TS.size());
          return TS.get(index);
        }
         }
    
    

}
