import java.util.ArrayList;

class Program {
    
    public static void run() {
        Console C = new Console();
        Kunde k = C.read_data_kunde();
        
        BunchOfTeststations BoTS = new BunchOfTeststations();
        Test_station TS = BoTS.find_TestStation(k);  
        
        if (TS == null) C.alert("Wir haben leider kein Testzentrum für sie gefunden");
        else{
        BunchOfTests BoCovT = new BunchOfTests(); 
        COVID19_Test CT = BoCovT.chooseTest(k);
        Termin meeting = new Termin(k,TS,CT);  
        meeting.createAppointment();
        laborbefund l = new laborbefund(meeting);
        l.Meldung_an_Gesundheitsamt();
       }
    }
}
    



