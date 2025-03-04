
package Adressbuch;

import java.util.ArrayList;


public class PI {
   public static ArrayList <PI> liste = new ArrayList<>();
   
   String vorname;
   String nachname;
   String telefonnummer;
   String adresse;
   
  
   PI(String vorname, String nachname, String telefonnummer ,String adresse){
       this.vorname = vorname;
       this.nachname = nachname;
       this.telefonnummer = telefonnummer;
       this.adresse = adresse;
       
   }

   
  
  

    
   
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

  
}

