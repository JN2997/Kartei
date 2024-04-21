import java.util.*;

public class Kartei {
    private Map<String, Freund> freunde = new HashMap<>();
    private int idCounter = 1;

    public void freundHinzufuegen(Freund freund) 
    {
        freunde.put(freund.getIdentNr(), freund);
    }

    public void freundAendern(String identNr, String[] neueAttribute) 
    {
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
            freund.setHausnummer(neueAttribute[9]);
        }
    }  

    public Freund freundSuchen(String identNr) 
    { 
        return freunde.get(identNr);
    }
    
    public String freundSuchenNachname(String nachname) 
    {
        for (Freund freund : freunde.values()) 
        {
            if (freund.getNachname().equals(nachname)) 
            {
                return freund.getIdentNr();
            }
        }
        return "";
    }

    public void freundLoeschen(String identNr) 
    {
        freunde.remove(identNr);
    }

    public void telefonlisteAusgeben() 
    {	
    	if (freunde.isEmpty())
    	{
    		System.out.println("\nKeine Freunde in der Kartei vorhanden\n");
    	}
    	else
    	{
	        for (Freund freund : freunde.values()) 
	        {
	            System.out.println("ID: " + freund.getIdentNr() + "Vorname: " + freund.getVorname() + ", Nachname: " + freund.getNachname() + ", Telefon: " + freund.getTelefon() + ", Handy: " + freund.getHandy());
	        }
    	}
    }

    public int anzahlFreunde() {
        return freunde.size();
    }

    public String generiereIdentNr() 
    {
    	return String.format("ID%d", idCounter++);
    }
}
