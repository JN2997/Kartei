
public class Freund {
    private final String identNr;
	private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String telefon;
    private String handy;
    private String email;
    private String plz;
    private String ort;
    private String strasse;
    private String hausnummer;

    public Freund(String identNr, String vorname, String nachname, String geburtsdatum, String telefon, String handy, String email, String ort, String plz, String strasse, String hausnummer) 
    {
        this.identNr = identNr;
    	this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.telefon = telefon;
        this.handy = handy;
        this.email = email;
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
    }
    public String getIdentNr() {
        return this.identNr;
    }
    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public String getGeburtsdatum() {
        return this.geburtsdatum;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public String getHandy() {
        return this.handy;
    }

    public String getEmail() {
        return this.email;
    }

    public String getOrt() {
        return this.ort;
    }
    public String getPlz() {
        return this.plz;
    }
    public String getStrasse() {
        return this.strasse;
    }
    public String getHausnummer() {
        return this.hausnummer;
    }
    // Setter-Methoden

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setHandy(String handy) {
        this.handy = handy;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    public void setPlz(String plz) {
        this.plz = plz;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    //Sondermethoden um Attribute einzeln zu erhalten, aber alle am Stück abzufragen
    public String getAttribut(String attributName) 
    {
        switch (attributName) 
        {
            case "vorname":
                return vorname;
            case "nachname":
                return nachname;
            case "geburtsdatum":
                return geburtsdatum;
            case "telefon":
                return telefon;
            case "handy":
                return handy;
            case "email":
                return email;
            case "ort":
                return ort;
            case "plz":
                return plz;
            case "strasse":
                return strasse;
            case "hausnummer":
                return hausnummer;
            default:
                return null;
        }
    }
    //Sondermethode um alle Attribute auszugeben
    public String getAlleAttribute() 
    {
        return "\nID-Nummer: " + identNr + "\nVorname: " + vorname + "\nNachname: " + nachname + "\nGeburtsdatum: " + geburtsdatum + "\nTelefon: " + telefon + "\nHandy: " + handy + "\nEmail: " + email + "\nOrt: " + ort + "\nPLZ: " + plz + "\nStrasse: " + strasse + "\nHausnummer: " + hausnummer + "\n";
    }
    
    
}