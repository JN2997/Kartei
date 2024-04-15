import java.util.*;

public class Kartei {
	
	private List<Freund> freunde;

    public Kartei() {
        this.freunde = new ArrayList<>();
    }

    public void hinzufuegen(Freund freund) {
        freunde.add(freund);
    }

    public void aendern(String identNr, Freund freund) {
        for (int i = 0; i < freunde.size(); i++) {
            if (freunde.get(i).getIdentNr() == identNr) {
                freunde.set(i, freund);
                break;
            }
        }
    }

    public void loeschen(String identNr) {
        freunde.removeIf(f -> f.getIdentNr() == identNr);
    }

    public Freund sucheNachname(String nachname) {
        for (Freund f : freunde) {
            if (f.getNachname().equals(nachname)) {
                return f;
            }
        }
        return null;
    }

    public Freund sucheIdentNr(String identNr) {
        for (Freund f : freunde) {
            if (f.getIdentNr() == identNr) {
                return f;
            }
        }
        return null;
    }

    public int anzahlAusgeben() {
        return freunde.size();
    }
}

