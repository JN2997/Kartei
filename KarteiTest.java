import java.util.*;

public class KarteiTest 
{
    public static void main(String[] args) 
    {
        Kartei kartei = new Kartei();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("1: Freund hinzufügen \n2: Freund ändern \n3: Freund löschen \n4: Freund suchen \n5: Telefonliste ausgeben \n6: Anzahl der Freunde anzeigen \n7: Beenden");
            int auswahl = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (auswahl) 
            {
                case 1:
                    System.out.println("Geben Sie die Details des Freundes ein:");
                    System.out.print("Vorname: ");
                    String vorname = scanner.nextLine().trim();
                    System.out.print("Nachname: ");
                    String nachname = scanner.nextLine().trim();
                    System.out.print("Geburtsdatum: ");
                    String geburtsdatum = scanner.nextLine().trim();
                    System.out.print("Telefon: ");
                    String telefon = scanner.nextLine().trim();
                    System.out.print("Handy: ");
                    String handy = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();
                    System.out.print("Ort: ");
                    String ort = scanner.nextLine().trim();
                    System.out.print("PLZ: ");
                    String plz = scanner.nextLine().trim();
                    System.out.print("Straße: ");
                    String strasse = scanner.nextLine().trim();
                    System.out.print("Hausnummer: ");
                    String hausnummer = scanner.nextLine().trim();
                    Freund freund = new Freund(kartei.generiereIdentNr(), vorname, nachname, geburtsdatum, telefon, handy, email, ort, plz, strasse, hausnummer);
                    kartei.freundHinzufuegen(freund);
                    System.out.println("Freund erfolgreich hinzugefügt");
                    break;
                case 2:
                    System.out.println("Geben Sie die Identifikationsnummer des Freundes ein, den Sie ändern möchten:");
                    String identNr = scanner.nextLine();
                    System.out.println("Geben Sie die neuen Daten Komma getrennt ein:");
                    String[] aendern = scanner.nextLine().split(",");
                    kartei.freundAendern(identNr, aendern[0].trim(), aendern[1].trim(), aendern[2].trim(), aendern[3].trim(), aendern[4].trim(), aendern[5].trim(), aendern[6].trim(), aendern[7].trim(), aendern[8].trim());
                    System.out.println("Freund erfolgreich geändert");
                    break;
                case 3:
                    System.out.println("Geben Sie die Identifikationsnummer des Freundes ein, den Sie löschen möchten:");
                    identNr = scanner.nextLine();
                    kartei.freundLoeschen(identNr);
                    System.out.println("Freund erfolgreich gelöscht");
                    break;
                case 4:
                	System.out.println("Wonach möchten Sie suchen, der ID oder dem Nachnamen? \n1: ID \n2: Nachname");
                    int auswahl2 = scanner.nextInt();
                    scanner.nextLine();
                    Freund gesuchterFreund = null;
                    switch (auswahl2)
                    {
                        case 1:
                            System.out.println("Geben Sie die ID an:");
                            String identNr1 = scanner.nextLine();
                            gesuchterFreund = kartei.freundSuchen(identNr1);
                            break;
                        case 2:
                            System.out.println("Geben Sie den Nachnamen an:");
                            String nachname1 = scanner.nextLine();
                            gesuchterFreund = kartei.freundSuchen(kartei.freundSuchenNachname(nachname1));
                            break;
                    }
                    if (gesuchterFreund != null) 
                    {
                        System.out.println("Freund gefunden: " + gesuchterFreund.getVorname() + " " + gesuchterFreund.getNachname());
                    } else 
                    {
                        System.out.println("Freund nicht gefunden.");
                    }
//                    System.out.println("Wonach möchten Sie suchen, der ID oder dem Nachnamen? \n1: ID \n2: Nachname");
//                    int auswahl2 = scanner.nextInt();
//                    scanner.nextLine();
//                    switch (auswahl2)
//                    {
//                	case 1:
//                		System.out.println("Geben Sie die ID an:");
//                		identNr = scanner.nextLine();
//                		Freund gesuchterFreund = kartei.freundSuchen(identNr);
//                		if (gesuchterFreund != null) 
//                		{
//                			System.out.println("Freund gefunden: " + gesuchterFreund.getVorname() + " " + gesuchterFreund.getNachname());
//                		} else 
//                		{
//                			System.out.println("Freund nicht gefunden.");
//                		}
//                		break;
//                	case 2:
//                		System.out.println("Geben Sie den Nachnamen an:");
//                		nachname = scanner.nextLine();
//                		Freund gesuchterFreund2 = kartei.freundSuchen(kartei.freundSuchenNachname(nachname));
//                		if (gesuchterFreund2 != null) 
//                		{
//                			System.out.println("Freund gefunden: " + gesuchterFreund2.getVorname() + " " + gesuchterFreund2.getNachname());
//                		} else 
//                		{
//                			System.out.println("Freund nicht gefunden.");
//                		}
//                		break;
//                    }
                    break;
                case 5:
                    kartei.telefonlisteAusgeben();
                    break;
                case 6:
                    System.out.println("Anzahl der Freunde: " + kartei.anzahlFreunde());
                    break;
                case 7:
                	if (auswahl == 7) {
                        System.out.println("Anwendung wird beendet.");
                        scanner.close();  // Schließen Sie das Scanner-Objekt
                        System.exit(0);
                	}
            }
        }
    }
}