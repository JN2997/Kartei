import java.util.*;

public class Mainprogramm 
{
    public static void main(String[] args) 
    {
        Kartei kartei = new Kartei(); // Erstellen neuer Instanz Klasse Kartei
        Scanner scanner = new Scanner(System.in); // Erstellen eines neuen Scanner-Objekts

        while (true)// Endlosschleife, um Menü widerholt anzuzeigen, bis Programm beendet wird
	    {	
	        try
	        {
	        	//Menüausgabe
	            System.out.println("Drücken Sie eine Zahl und bestätigen Sie mit Enter, um einen Menüpunkt auszuwählen.\n1: Freund hinzufügen \n2: Freund ändern \n3: Freund löschen \n4: Freund suchen \n5: Telefonliste ausgeben \n6: Anzahl der Freunde anzeigen \n7: Beenden");
	            int auswahl = scanner.nextInt(); // Einlesen Benutzerauswahl
	            scanner.nextLine();  
	
	            String identNr;
				switch (auswahl) //Auswertung der Auswahl
	            {
	                case 1: //Freund hinzufügen
	                    System.out.println("Geben Sie die Details des Freundes ein und Bestätigen Sie diese mit Enter:");
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
	                    // Erstellen einer neuen Freund-Instanz mit den eingegebenen Details
	                    Freund freund = new Freund(kartei.generiereIdentNr(), vorname, nachname, geburtsdatum, telefon, handy, email, ort, plz, strasse, hausnummer);
	                    kartei.freundHinzufuegen(freund); //Freund-Objekt zur Kartei hinzufügen
	                    System.out.println("\nIhr Freund wurde mit folgenden Daten erfolgreich hinzugefügt: " + freund.getAlleAttribute()); //Bestätigung der Speicherung + Ausgabe
	                    break;
	                    
	                case 2: //Freund ändern
	                    while (true) 
	                    {
	                        System.out.println("Geben Sie die ID des Freundes ein, den Sie ändern möchten oder 'zurück', um zum Hauptmenü zurückzukehren:");
	                        String identNr1 = scanner.nextLine(); //ID kann eingegeben werden oder zurück ins Hauptmenü

	                        if (identNr1.equalsIgnoreCase("zurück")) //Anweisung um zurück ins Hauptmenü zu gelangen
	                        {
	                            break;
	                        }

	                        if (!identNr1.matches("ID\\d+"))  //Falls etwas anderes als eine ID eingegeben wird, wird dieser Fehler gecatcht
	                        {
	                            System.out.println("Fehlerhafte Eingabe, bitte geben Sie eine ID ein, die das Format ID + Zahl hat.\n");
	                            continue;
	                        }

	                        Freund alterFreund = kartei.freundSuchen(identNr1); //ID wird in der Kartei gesucht

	                        if (alterFreund == null)  //Wenn kein Freund unter der ID gefunden wird, dann wird ebenfalls eine Fehlermeldung ausgegeben
	                        {
	                            System.out.println("Kein Freund unter dieser ID gefunden, versuchen Sie es erneut.\n");
	                            continue;
	                        }
	                    String[] attribute = new String[]{"vorname", "nachname", "geburtsdatum", "telefon", "handy", "email", "ort", "plz", "strasse", "hausnummer"};
	                    String[] aendern = new String[10];
	                    
	                    for (int i = 0; i < attribute.length; i++) // Schleife durch alle Attribute, bis alle Attribute einmal angezeigt wurden
	                    {	//Eingabe des neuen Attributwerts und Anzeigen des aktuellen Wertes
	                        System.out.println("Geben Sie " + attribute[i] + " ein und bestätigen mit Enter, aktueller Wert: " + alterFreund.getAttribut(attribute[i]) + ":"); 
	                        String eingabe = scanner.nextLine();
	                        // Wenn die Eingabe leer ist, wird der alte Wert beibehalten, ansonsten wird der neue Wert gesetzt
	                        aendern[i] = eingabe.isEmpty() ? alterFreund.getAttribut(attribute[i]) : eingabe; 
	                    }
	                    kartei.freundAendern(identNr1, aendern); // Ändern des Freundes in der Kartei
	                    System.out.println("Freund erfolgreich geändert");
	                    break;
	                    }
	                    break;
	                case 3: //Freund löschen
	                    System.out.println("Geben Sie die ID des Freundes ein, den Sie löschen möchten:");
	                    identNr = scanner.nextLine();
	                    kartei.freundLoeschen(identNr); // Löschen des Freundes aus der Kartei
	                    System.out.println("Freund erfolgreich gelöscht");
	                    break;
	                case 4: //Freund suchen anhand der ID oder des Nachnamens
	                	System.out.println("Wonach möchten Sie suchen? \n1: ID \n2: Nachname");
	                    int auswahl2 = scanner.nextInt();
	                    scanner.nextLine();
	                    Freund gesuchterFreund = null; //Variable für gesuchten Freund wird erstellt und = null gesetzt
	                    switch (auswahl2)
	                    {
	                        case 1: //Suche in der Kartei anhand der ID Nummer
	                            System.out.println("Geben Sie die ID an:");
	                            String identNr1 = scanner.nextLine();
	                            gesuchterFreund = kartei.freundSuchen(identNr1);
	                            break;
	                        case 2: //Suche in der Kartei anhand des Nachnamens
	                            System.out.println("Geben Sie den Nachnamen an:");
	                            String nachname1 = scanner.nextLine();
	                            gesuchterFreund = kartei.freundSuchen(kartei.freundSuchenNachname(nachname1));
	                            break;
	                    }
	                    if (gesuchterFreund != null) //Ausgabe aller Parameter, wenn Freund gefunden
	                    {
	                        System.out.println("Freund gefunden: " + gesuchterFreund.getAlleAttribute());
	                    } else //Ausgabe, wenn Freund nicht gefunden wird
	                    {
	                        System.out.println("Freund nicht gefunden.");
	                    }
	                    break;
	                case 5: //Ausgabe der Telefonliste mit der Methode aus der Klasse Kartei
	                    kartei.telefonlisteAusgeben();
	                    break;
	                case 6:
	                    System.out.println("Anzahl der Freunde: " + kartei.anzahlFreunde());
	                    break;
	                case 7:
	                	if (auswahl == 7) 
	                	{
	                        System.out.println("Kartei wird geschlossen und die Datensätze verworfen...");
	                        scanner.close();  // Schließen Sie das Scanner-Objekt
	                        System.exit(0);
	                	}
	                default: // Default catcht alle Ganzzahleingaben, die nicht im Menü aufgeführt sind und gibt eine Fehlermeldung aus
	                {
	                	System.out.println("\nFehlerhafte Eingabe, bitte versuchen Sie es erneut.\n");
	                }
	            }
            }
	    	catch (InputMismatchException e) //Fehler für Eingaben die keine Ganzzahl sind wird mit einer Fehlerausgabe
	    	{
	    		System.out.println("\nFehlerhafte Eingabe, bitte versuchen Sie es erneut.\n");
	    		scanner.next(); //verhindert, dass die Fehlerausgabe in Dauerschleife läuft und das Programm abstürzen lässt
	    	}
        }
    }
}