 import java.util.*;
import java.io.*;

public class KarteiTest {
    public static void main(String[] args) {
        Kartei kartei = new Kartei();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Freund hinzufügen");
            System.out.println("2. Freund löschen");
            System.out.println("3. Freund ändern");
            System.out.println("4. Telefonliste anzeigen");
            System.out.println("5. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
            case 1:
                // Freund hinzufügen...
                System.out.println("Geben Sie die Details des Freundes ein:");
                System.out.print("Vorname: ");
                String vorname = scanner.nextLine();
                System.out.print("Nachname: ");
                String nachname = scanner.nextLine();
                System.out.print("Geburtsdatum: ");
                String geburtsdatum = scanner.nextLine();
                System.out.print("Telefon: ");
                String telefon = scanner.nextLine();
                System.out.print("Handynummer: ");
                String handy = scanner.nextLine();
                System.out.print("E-Mail: ");
                String email = scanner.nextLine();
                System.out.print("Ort: ");
                String ort = scanner.nextLine();
                System.out.print("Postleitzahl: ");
                String plz = scanner.nextLine();
                System.out.print("Straße: ");
                String strasse = scanner.nextLine();
                System.out.print("Hausnummer: ");
                String hausnummer = scanner.nextLine();                 		
                        		
                // Weitere Details hier...
                Freund freund = new Freund(vorname, nachname, geburtsdatum, telefon, handy, email, ort, plz, strasse, hausnummer);
                kartei.hinzufuegen(freund);
                break;
//            case 2:
//                // Freund löschen...
//                System.out.print("Geben Sie die ID des zu löschenden Freundes ein: ");
//                identNr = scanner.nextLine();
//                kartei.loeschen(identNr);
//                break;
            case 3:
                // Freund ändern...
                System.out.print("Geben Sie die ID des zu ändernden Freundes ein: ");
                String identNrAendern = scanner.nextLine();
                System.out.println("Geben Sie die neuen Details des Freundes ein:");
                System.out.print("Vorname: ");
                String vornameAendern = scanner.nextLine();
                System.out.print("Nachname: ");
                String nachnameAendern = scanner.nextLine();
                System.out.print("Geburtsdatum: ");
                String geburtsdatumAendern = scanner.nextLine();
                System.out.print("Telefon: ");
                String telefonAendern = scanner.nextLine();
                System.out.print("Handynummer: ");
                String handyAendern = scanner.nextLine();
                System.out.print("E-Mail: ");
                String emailAendern = scanner.nextLine();
                System.out.print("Ort: ");
                String ortAendern = scanner.nextLine();
                System.out.print("Postleitzahl: ");
                String plzAendern = scanner.nextLine();
                System.out.print("Straße: ");
                String strasseAendern = scanner.nextLine();
                System.out.print("Hausnummer: ");
                String hausnummerAendern = scanner.nextLine();  
                Freund geaenderterFreund = new Freund(vornameAendern, nachnameAendern, geburtsdatumAendern, telefonAendern, handyAendern, emailAendern, ortAendern, plzAendern, strasseAendern, hausnummerAendern);
                kartei.aendern(identNrAendern, geaenderterFreund);
                break;
//            case 4:
//                // Telefonliste anzeigen...
//                for (int i = 0; i < kartei.anzahlAusgeben(); i++) {
//                    Freund f = kartei.sucheIdentNr(i+1);
//                    if (f != null) {
//                        System.out.println(f.getVorname() + " " + f.getNachname() + ": " + f.getTelefon());
//                    }
//                }
//                break;
            case 5:
                System.out.println("Auf Wiedersehen!");
                return;
            default:
                System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
        }
    }
}

public static void speichern(Kartei kartei) {
    try {
        FileOutputStream fileOut = new FileOutputStream("freunde.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(kartei);
        out.close();
        fileOut.close();
    } catch (IOException i) {
        i.printStackTrace();
    }
}

public static Kartei laden() {
    Kartei kartei = null;
    try {
        FileInputStream fileIn = new FileInputStream("freunde.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        kartei = (Kartei) in.readObject();
        in.close();
        fileIn.close();
    } catch (IOException i) {
        i.printStackTrace();
    } catch (ClassNotFoundException c) {
        System.out.println("Kartei-Klasse nicht gefunden");
        c.printStackTrace();
    }
    return kartei;
	}
}
