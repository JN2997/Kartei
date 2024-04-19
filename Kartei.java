import java.util.*;

public class Kartei {
    private Map<String, Freund> freunde = new HashMap<>();
    private int idCounter = 0;

    public void freundHinzufuegen(Freund freund) 
    {
        freunde.put(freund.getIdentNr(), freund);
    }

    public void freundAendern(String identNr, String vorname, String nachname, String geburtsdatum, String telefon, String handy, String email, String ort, String strasse, String hausnummer) 
    {
        Freund freund = freunde.get(identNr);
        if (freund != null) {
            freund.setVorname(vorname);
            freund.setNachname(nachname);
            freund.setGeburtsdatum(geburtsdatum);
            freund.setTelefon(telefon);
            freund.setHandy(handy);
            freund.setEmail(email);
            freund.setOrt(ort);
            freund.setStrasse(strasse);
            freund.setHausnummer(hausnummer);
        }
    }

    public Freund freundSuchen(String identNr) 
    {
        return freunde.get(identNr);
    }
    
    public String freundSuchenNachname(String nachname)
    {
		String temp = "";
    	for (Freund freund : freunde.values()) 
    	{

    		if
    		(freund.getNachname().equals(nachname))
    		{
    			temp = freund.getIdentNr();
    			//System.out.println(freund.getIdentNr());
    		}
    	}
    	return temp;
    }

    public void freundLoeschen(String identNr) 
    {
        freunde.remove(identNr);
    }

    public void telefonlisteAusgeben() {
        for (Freund freund : freunde.values()) {
            System.out.println("Vorname: " + freund.getVorname() + ", Nachname: " + freund.getNachname() + ", Telefon: " + freund.getTelefon() + ", Handy: " + freund.getHandy());
        }
    }

    public int anzahlFreunde() {
        return freunde.size();
    }

    public String generiereIdentNr() 
    {
    	return String.format("ID%03d", idCounter++);
    }
}
