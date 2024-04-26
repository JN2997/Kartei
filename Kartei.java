import java.util.*;

public class Kartei 
{	
	//Hash-Map zum Speichern des Key-Value Paares, Key = String = identNr & Value = Freund-Objekt
    private Map<String, Freund> freunde = new HashMap<>();
    private int idCounter = 1; //Zählervariable für Methode generiereIdentNr()

    public void freundHinzufuegen(Freund freund) //Methode um Freund-Objekt zu erzeugen
    // Die Methode wird erst getriggert, nachdem im Mainprogramm alles abgefragt wurde über die Konsole
    {
        freunde.put(freund.getIdentNr(), freund);
    }

    public void freundAendern(String identNr, String[] neueAttribute) //Methode um Freund-Objekt zu ändern
    {	
    	// Überprüft, ob der Freund in der Kartei existiert, wenn ja, dann können Attribute geändert werden
        Freund freund = freunde.get(identNr);
        if (freund != null) 
        {
            freund.setVorname(neueAttribute[0]);
            freund.setNachname(neueAttribute[1]);
            freund.setGeburtsdatum(neueAttribute[2]);
            freund.setTelefon(neueAttribute[3]);
            freund.setHandy(neueAttribute[4]);
            freund.setEmail(neueAttribute[5]);
            freund.setOrt(neueAttribute[6]);
            freund.setPlz(neueAttribute[7]);
            freund.setStrasse(neueAttribute[8]);
        }
    }  
    
    //Freund suchen in der Hash-Map anhand der IdentNr
    public Freund freundSuchen(String identNr) 
    { 
        return freunde.get(identNr);
    }
    
    //Freund suchen in der Hash-Map über die Attribute eines Freund-Objektes mit dem Nachnamen
    public String freundSuchenNachname(String nachname) 
    {
        for (Freund freund : freunde.values()) 
        {
            if (freund.getNachname().equals(nachname)) 
            {
                return freund.getIdentNr(); //gewünschter Rückgabewert
            }
        }
        return "";
    }
    
    //Methode um Freund-Objekt anhand identNr aus Hash-Map zu löschen
    public void freundLoeschen(String identNr) 
    {
        freunde.remove(identNr);
    }
    
    //Methode um eine einfache Telefonliste auszugeben
    public void telefonlisteAusgeben() 
    {	
    	if (freunde.isEmpty()) //Fehlerbehandlung, falls keine Freunde in der Kartei vorhanden sind
    	{
    		System.out.println("\nKeine Freunde in der Kartei vorhanden\n");
    	}
    	else
    	{
	        for (Freund freund : freunde.values())  //Wenn ein Freund-Objekt gefunden wird, sollen einige Attribute ausgegeben werden
	        {
	            System.out.println("ID: " + freund.getIdentNr() + "Vorname: " + freund.getVorname() + ", Nachname: " 
	        + freund.getNachname() + ", Telefon: " + freund.getTelefon() + ", Handy: " + freund.getHandy());
	        }
    	}
    }

    //Methode zur Ausgabe der Anzahl von Freunden
    public int anzahlFreunde() 
    {
        return freunde.size();
    }

    //Methode um die IdentNr zu generieren 
    public String generiereIdentNr() 
    {
    	return String.format("ID%d", idCounter++);
    }
}
