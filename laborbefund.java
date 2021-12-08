import java.util.*;
/*import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;*/


public class laborbefund {
    Termin tr;
    String Rückmeldung;
    public laborbefund(Termin tr){
        this.tr = tr;
    }
    public void setRückmeldung (String nachricht){
        Rückmeldung=nachricht;
    }
    public void Meldung_an_Gesundheitsamt(){
      /*if (k.t.getErgebnis() == '+'){
      // Recipient's email ID needs to be mentioned.
      String to = "gesundheitsamt-corona@dresden.de";
      // Sender's email ID needs to be mentioned
      String from = "web@gmail.com";
      // Assuming you are sending email from localhost
      String host = "localhost";
      // Get system properties
      Properties properties = System.getProperties();
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      // Get the default Session object.
      Runtime.Version session = Session.getDefaultInstance(properties);
      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         // Set Subject: header field
         message.setSubject("new corona virus case");
         // Now set the actual message
         message.setText(tr.k);
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }*/
   }

    
    public String toString(){
        return tr.k+ "Ergebnis : "+tr.ct.getErgebnis() + Rückmeldung;
    }
}
