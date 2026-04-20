import java.util.ArrayList;
import java.util.Scanner;

public class MainShop {
    static Scanner sc = new Scanner(System.in);
    static Produkt produkt = new Produkt();
    static Monitor moni = new Monitor();
    static Motherboard moth = new Motherboard();
    static Tastatur tast = new Tastatur();
    static Maus maus = new Maus();
    static ArrayList<Monitor> moniList = new ArrayList<Monitor>();
    static ArrayList<Motherboard> mothList = new ArrayList<Motherboard>();
    static ArrayList<Tastatur> tastList = new ArrayList<Tastatur>();
    static ArrayList<Maus> mausList = new ArrayList<Maus>();

    public static void main(String[] args) {
        produktDummies();
        hauptMenue();
    }

    public static void produktDummies() {
        Monitor moni1 = new Monitor("BENQ", "PD2705UA",
                499.00, 27);
        Monitor moni2 = new Monitor("Sony", "INZONE M9",
                1005.00, 27);
        Monitor moni3 = new Monitor("Samsung", "ViewFinity S70D LS32D700EAUXEN",
                222.89, 32);
        moniList.add(moni1);
        moniList.add(moni2);
        moniList.add(moni3);
        Motherboard moth1 = new Motherboard("ASUS", "ROG Strix B550-F Gaming",
                129.79, "ATX", "Sockel AM3");
        Motherboard moth2 = new Motherboard("ASUS", "TUF Gaming B650-Plus",
                140.43, "microATX", "AMD B650" );
        Motherboard moth3 = new Motherboard("Gigabyte", "B850 Eagle Ice",
                173.16, "microATX", "AMD B850");
        mothList.add(moth1);
        mothList.add(moth2);
        mothList.add(moth3);
        Tastatur tast1 = new Tastatur("Logitech", "G815",
                213.42, 109, true);
        Tastatur tast2 = new Tastatur("Razer", "RZ03-03540100-R3M1",
                99.00, 108, true);
        Tastatur tast3 = new Tastatur("Nyfter", "Gaming Tastatur",
                109.00, 62, true);
        tastList.add(tast1);
        tastList.add(tast2);
        tastList.add(tast3);
        Maus maus1 = new Maus("Cherry", "XTRFY M68",
                139.99, false);
        Maus maus2 = new Maus("Logitech", "G502 X Lightspeed",
                129.00, false);
        Maus maus3 = new Maus("Razer", "DeathAdder V2",
                101.99, true);
        mausList.add(maus1);
        mausList.add(maus2);
        mausList.add(maus3);
    }

    public static void hauptMenue() {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("PC-Shop\t\t\t\tHauptmenü\t\t\tvon: André Trotzowski");
        System.out.println("-------------------------------------------------------------");
        System.out.println(" 1) Produkt anlegen");
        System.out.println(" 2) Produkt bearbeiten");
        System.out.println(" 3) Produkt suchen");
        System.out.println(" 4) Produkt löschen");
        System.out.println(" 0) Shop beenden");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Bitte wählen: ");
        String auswahl = sc.next();
        if (auswahl.equals("0"))
            shopBeenden();
        else if (auswahl.equals("1"))
            produktAnlegen();
        else if (auswahl.equals("2"))
            produktBearbeiten();
        else if (auswahl.equals("3"))
            produktSuchen();
        else if (auswahl.equals("4"))
            produktLoeschen();
        else {
            System.out.println("\nFehlerhafte Eingabe");
            hauptMenue();
        }
    }

    public static void leereProduktliste() {
        if (moniList.size() == 0 && mothList.size() == 0
                && tastList.size() == 0 && mausList.size() == 0) {
            System.out.println("\nKeine Produkte vorhanden");
            hauptMenue();
        }
    }

    public static void wiederholung() {
        System.out.print("\nNoch ein Produkt anlegen? (J)a oder (N)ein ");
        String auswahl = sc.next().toUpperCase();
        if (auswahl.equals("J"))
            produktAnlegen();
        else if (auswahl.equals("N"))
            hauptMenue();
        else if (!auswahl.equals("J") | !auswahl.equals("N")) {
            System.out.println("\nFehlerhafte Eingabe");
            wiederholung();
        }
    }

    public static void preisbestimmen() {
        System.out.print("Preis: ");
        if (sc.hasNextDouble()) {
            double preis = (sc.nextDouble());
            if (preis > 0)
                produkt.setPreis(preis);
            else {
                System.out.println("Fehlerhafte Eingabe (Nur positive Werte!)");
                preisbestimmen();
            }
        }
        else {
            String falscheEingabe = sc.next();
            System.out.println("Fehlerhafte Eingabe (Nur Zahlen!)");
            preisbestimmen();
        }
    }

    public static void produktAnlegen2() {
        System.out.print("Marke: ");
        String marke = sc.next();
        produkt.setMarke(marke);
        System.out.print("Modell: ");
        String modell = sc.next();
        produkt.setModell(modell);
        preisbestimmen();
    }

    public static void groesseBestimmen() {
        System.out.print("Größe: ");
        if (sc.hasNextDouble()) {
            double groesse = sc.nextDouble();
            if (groesse > 0)
                moni.setGroesse(groesse);
            else {
                System.out.println("Fehlerhafte Eingabe (Nur positive Werte!)");
                groesseBestimmen();
            }
        }
        else {
            String falscheEingabe = MainShop.sc.next();
            System.out.println("Fehlerhafte Eingabe (Nur Zahlen!)");
            groesseBestimmen();
        }
    }

    public static void monitorAnlegen() {
        produktAnlegen2();
        groesseBestimmen();
        moni.setMarke(produkt.getMarke());
        moni.setModell(produkt.getModell());
        moni.setPreis(produkt.getPreis());
    }

    public static void motherboardAnlegen() {
        produktAnlegen2();
        System.out.print("Formfaktor: ");
        String formfaktor = sc.next();
        moth.setFormfaktor(formfaktor);
        System.out.print("Chipsatz: ");
        String chipsatz = sc.next();
        moth.setChipsatz(chipsatz);
        moth.setMarke(produkt.getMarke());
        moth.setModell(produkt.getModell());
        moth.setPreis(produkt.getPreis());
    }

    public static void anzahlTastenBestimmen() {
        System.out.print("Anzahl Tasten: ");
        if (sc.hasNextInt()) {
            int anzahlTasten = sc.nextInt();
            if (anzahlTasten > 0)
                tast.setAnzahlTasten(anzahlTasten);
            else {
                System.out.println("Fehlerhafte Eingabe (Nur positive Werte!)");
                anzahlTastenBestimmen();
            }
        }
        else {
            String falscheEingabe = MainShop.sc.next();
            System.out.println("Fehlerhafte Eingabe (Nur Zahlen!)");
            anzahlTastenBestimmen();
        }
    }

    public static void beleuchtetBestimmen() {
        System.out.print("beleuchtet:\n(J)a oder (N)ein: ");
        String leuchtet = sc.next().toUpperCase();
        if (leuchtet.equals("J"))
            tast.setBeleuchtet(true);
        else if (leuchtet.equals("N"))
            tast.setBeleuchtet(false);
        else {
            System.out.println("Fehlerhafte Eingabe (Nur J oder N !)");
            beleuchtetBestimmen();
        }
    }

    public static void tastaturAnlegen() {
        produktAnlegen2();
        anzahlTastenBestimmen();
        beleuchtetBestimmen();
        tast.setMarke(produkt.getMarke());
        tast.setModell(produkt.getModell());
        tast.setPreis(produkt.getPreis());
    }

    public static void kabelgebundenBestimmen() {
        System.out.print("kabelgebunden: \n(J)a oder (N)ein ? ");
        String kabel = sc.next().toUpperCase();
        if (kabel.equals("J"))
            maus.setKabelgebunden(true);
        else if (kabel.equals("N"))
            maus.setKabelgebunden(false);
        else {
            System.out.println("Fehlerhafte Eingabe (Nur J oder N !)");
            kabelgebundenBestimmen();
        }
    }

    public static void mausAnlegen() {
        produktAnlegen2();
        kabelgebundenBestimmen();
        maus.setMarke(produkt.getMarke());
        maus.setModell(produkt.getModell());
        maus.setPreis(produkt.getPreis());
    }

    public static void produktAnlegen() {
        System.out.println("\n\u001B[4mProdukt anlegen\u001B[0m\n");
        System.out.println("1) Monitor\n2) Motherboard\n3) Tastatur\n4) Maus");
        System.out.print("\nBitte Nummer wählen: ");
        String auswahl = sc.next();
        if (auswahl.equals("1")) {
            System.out.println("\n\u001B[4mMonitor\u001B[0m");
            monitorAnlegen();
            moniList.add(moni);
            System.out.println("\nMonitor gespeichert");
            wiederholung();
        } else if (auswahl.equals("2")) {
            System.out.println("\n\u001B[4mMotherboard\u001B[0m");
            motherboardAnlegen();
            mothList.add(moth);
            System.out.println("\nMotherboard gespeichert");
            wiederholung();
        } else if (auswahl.equals("3")) {
            System.out.println("\n\u001B[4mTastatur\u001B[0m");
            tastaturAnlegen();
            tastList.add(tast);
            System.out.println("\nTastatur gespeichert");
            wiederholung();
        } else if (auswahl.equals("4")) {
            System.out.println("\n\u001B[4mMaus\u001B[0m");
            mausAnlegen();
            mausList.add(maus);
            System.out.println("\nMaus gespeichert");
            wiederholung();
        } else {
            System.out.println("\nFehlerhafte Eingabe");
            produktAnlegen();
        }
    }

    public static void produkteAnzeigen() {
        for (int i = 0; i < moniList.size(); i++) {
            System.out.println("\nNr. " + (1+i) + moniList.get(i));
        }
        for (int i = 0; i < mothList.size(); i++) {
            System.out.println("\nNr. " + (moniList.size() + (1+i)) + mothList.get(i));
        }
        for (int i = 0; i < tastList.size(); i++) {
            System.out.println("\nNr. " + (moniList.size() + mothList.size() +
                    (1+i)) + tastList.get(i));
        }
        for (int i = 0; i < mausList.size(); i++) {
            System.out.println("\nNr. " + (moniList.size() + mothList.size() +
                    tastList.size() + (1+i)) + mausList.get(i));
        }
    }

    public static void produktBearbeiten() {
        leereProduktliste();
        System.out.println("\n\u001B[4mProdukt bearbeiten\u001B[0m");
        produkteAnzeigen();
        System.out.print("\nWelches Produkt soll bearbeitet werden? (Nummer): ");
        if (sc.hasNextInt()) {
            int auswahl = sc.nextInt();
            for (int i = 0; i < moniList.size(); i++) {
                if ((moniList.size() - i) == auswahl) {
                    monitorAnlegen();
                    moniList.set(auswahl - 1, moni);
                    System.out.println("\nMonitor wurde bearbeitet");
                }
            }
            for (int i = 0; i < mothList.size(); i++) {
                if ((mothList.size() - i) == auswahl - moniList.size()) {
                    motherboardAnlegen();
                    mothList.set((auswahl - moniList.size()) - 1, moth);
                    System.out.println("\nMotherboard wurde bearbeitet");
                }
            }
            for (int i = 0; i < tastList.size(); i++) {
                if ((tastList.size() - i) == auswahl - (moniList.size() + mothList.size())) {
                    tastaturAnlegen();
                    tastList.set((auswahl - (moniList.size() + mothList.size())) - 1, tast);
                    System.out.println("\nTastatur wurde bearbeitet");
                }
            }
            for (int i = 0; i < mausList.size(); i++) {
                if ((mausList.size() - i) == auswahl - (moniList.size() +
                        mothList.size() + tastList.size())) {
                    mausAnlegen();
                    mausList.set((auswahl - (moniList.size() + mothList.size() +
                            tastList.size())) - 1, maus);
                    System.out.println("\nMaus wurde bearbeitet");
                }
            }
            if (auswahl <= 0 || auswahl > moniList.size() + mothList.size() +
                    tastList.size() + mausList.size()) {
                System.out.println("\nFehlerhafte Eingabe");
                produktBearbeiten();
            }
            else {
                System.out.print("\nNoch ein Produkt bearbeiten? (J)a oder (N)ein: ");
                if (sc.hasNext()) {
                    String eingabe = sc.next().toUpperCase();
                    if (eingabe.equals("J"))
                        produktBearbeiten();
                    else if (eingabe.equals("N"))
                        hauptMenue();
                    else {
                        System.out.println("\nFehlerhafte Eingabe");
                        hauptMenue();
                    }
                }
            }
        }
        else {
            String falscheEingabe = sc.next();
            System.out.println("\nFehlerhafte Eingabe\n");
            produktBearbeiten();
        }
    }

    public static void produktSuchen() {
        leereProduktliste();
        System.out.println("\n\u001B[4mProdukt suchen\u001B[0m\n");
        System.out.print("Bitte Suchbegriff eingeben: ");
        String eingabe = sc.next().toLowerCase();
        int i;
        int nummer = 0;
        int zaehler = 0;
        for (i = 0; i < moniList.size(); i++) {
            String auswahl1 = Double.toString(moniList.get(i).getPreis());
            String auswahl2 = Double.toString(moniList.get(i).getGroesse());
            if (auswahl1.contains(eingabe) | auswahl2.contains(eingabe) |
                    moniList.get(i).getMarke().toLowerCase().contains(eingabe) |
                    moniList.get(i).getModell().toLowerCase().contains(eingabe)) {
                nummer += 1;
                System.out.println("\nNr. " + nummer + moniList.get(i));
                zaehler += 1;
            }
        }
        for (i = 0; i < mothList.size(); i++) {
            String auswahl = Double.toString(mothList.get(i).getPreis());
            if (auswahl.contains(eingabe) |
                    mothList.get(i).getMarke().toLowerCase().contains(eingabe) |
                    mothList.get(i).getModell().toLowerCase().contains(eingabe) |
                    mothList.get(i).getFormfaktor().toLowerCase().contains(eingabe) |
                    mothList.get(i).getChipsatz().toLowerCase().contains(eingabe)) {
                nummer += 1;
                System.out.println("\nNr. " + nummer + mothList.get(i));
                zaehler += 1;
            }
        }
        for (i = 0; i < tastList.size(); i++) {
            String auswahl1 = Double.toString(tastList.get(i).getPreis());
            String auswahl2 = Integer.toString(tastList.get(i).getAnzahlTasten());
            if (auswahl1.contains(eingabe) | auswahl2.contains(eingabe) |
                    tastList.get(i).getMarke().toLowerCase().contains(eingabe) |
                    tastList.get(i).getModell().toLowerCase().contains(eingabe)) {
                nummer += 1;
                System.out.println("\nNr. " + nummer + tastList.get(i));
                zaehler += 1;
            }
        }
        for (i = 0; i < mausList.size(); i++) {
            String auswahl = Double.toString(mausList.get(i).getPreis());
            if (auswahl.contains(eingabe) |
                    mausList.get(i).getMarke().toLowerCase().contains(eingabe) |
                    mausList.get(i).getModell().toLowerCase().contains(eingabe)) {
                nummer += 1;
                System.out.println("\nNr. " + nummer + mausList.get(i));
                zaehler += 1;
            }
        }
        if (zaehler == 0)
            System.out.println("\nKein Produkt gefunden.");
        System.out.print("\nNochmal suchen? (J)a oder (N)ein: ");
        eingabe = sc.next().toUpperCase();
        if (eingabe.equals("J"))
            produktSuchen();
        else if (eingabe.equals("N"))
            hauptMenue();
        else {
            System.out.println("\nFehlerhafte Eingabe");
            hauptMenue();
        }
    }

    /**
     * Methode produktLoeschen:
     * - zunächst Überprüfung ob Produkte vorhanden sind mit der Methode leereProduktliste()
     * - dann Anzeigen der Produkte mit der Methode produkteAnzeigen()
     * - nach Abfrage wird geprüft, ob Kundeneingabe ein Integer Wert ist oder nicht
     */
    public static void produktLoeschen() {
        leereProduktliste();
        System.out.println("\n\u001B[4mProdukt löschen\u001B[0m");
        produkteAnzeigen();
        System.out.print("\nWelches Produkt soll gelöscht werden (Nummer)? ");
        if (sc.hasNextInt()) {
            int auswahl = sc.nextInt();
            for (int i = 0; i < moniList.size() || i < mothList.size() ||
                    i < tastList.size() || i < mausList.size(); i++) {
                if ((moniList.size() - i) == auswahl ||
                        (mothList.size() - i) == auswahl - moniList.size() ||
                        (tastList.size() - i) == auswahl - (moniList.size() +
                                mothList.size()) ||
                        (mausList.size() - i) == auswahl - (moniList.size() +
                                mothList.size() + tastList.size())) {
                    System.out.print("\nWirklich löschen? (J)a oder (N)ein: ");
                    String eingabe = sc.next().toUpperCase();
                    if (eingabe.equals("J")) {
                        if ((moniList.size() - i) == auswahl)
                            moniList.remove(auswahl - 1);
                        else if ((mothList.size() - i) == auswahl - moniList.size())
                            mothList.remove(auswahl - moniList.size() - 1);
                        else if ((tastList.size() - i) == auswahl - (moniList.size() +
                                mothList.size()))
                            tastList.remove(auswahl - (moniList.size() +
                                    mothList.size()) - 1);
                        else if ((mausList.size() - i) == auswahl - (moniList.size() +
                                mothList.size() + tastList.size()))
                            mausList.remove(auswahl - (moniList.size() +
                                    mothList.size() + tastList.size()) - 1);
                        System.out.println("\nProdukt Nr. " + auswahl + " gelöscht");
                        System.out.print("\nNoch ein Produkt löschen? (J)a oder (N)ein: ");
                        eingabe = sc.next().toUpperCase();
                        if (eingabe.equals("J"))
                            produktLoeschen();
                        else if (eingabe.equals("N"))
                            hauptMenue();
                        else {
                            System.out.println("Fehlerhafte Eingabe");
                            hauptMenue();
                        }
                    }
                    else if (eingabe.equals("N"))
                        hauptMenue();
                    else {
                        System.out.println("\nFehlerhafte Eingabe");
                        hauptMenue();
                    }
                }
            }
            System.out.println("\nFehlerhafte Eingabe");
            produktLoeschen();
        }
        else {
            String falscheEingabe = sc.next();
            System.out.println("\nFehlerhafte Eingabe");
            produktLoeschen();
        }
    }

    /**
     * - Methode shopBeenden:
     * - nach Abfrage wird Kundeneingabe groß gesetzt und überprüft.
     * - bei "j" Programm beenden, bei "n" Hauptmenü, bei "falscher Eingabe" Hauptmenü
     */
    public static void shopBeenden() {
        System.out.print("\nWirklich beenden? (J)a oder (N)ein: ");
        String eingabe = sc.next().toUpperCase();
        if (eingabe.equals("J")) {
            System.out.println("\nPC Shop wurde beendet");
            System.exit(0);
        }
        else if (eingabe.equals("N"))
            hauptMenue();
        else {
            System.out.println("\nFehlerhafte Eingabe");
            hauptMenue();
        }
    }
}