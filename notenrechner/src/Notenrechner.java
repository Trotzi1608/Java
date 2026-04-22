import java.util.Scanner;
import java.util.ArrayList;

public class Notenrechner {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> punkte = new ArrayList<>();

    public static void main(String[] args){
        menue();
        auswahl();
    }

    private static void menue(){
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("1 - Punktzahl eingeben");
        System.out.println("2 - Punktzahl mit Note anzeigen");
        System.out.println("3 - Durchschnitt anzeigen");
        System.out.println("4 - Beste / Schlechteste Punktzahl anzeigen");
        System.out.println("5 - Punktzahl löschen");
        System.out.println("6 - Punktzahl ändern");
        System.out.println("0 - Programm beenden");
        System.out.println("-------------------------------------------");
    }

    private static void auswahl() {
        int auswahl = sc.nextInt();
        if (auswahl < 0 || auswahl > 6) {
            System.out.println("\tBitte nur 0 - 6 eingeben");
            main(null);
        }
        else {
            if (auswahl == 1)
                punktzahlEingeben();
            if (punkte.size() == 0 && (auswahl == 2 || auswahl == 3 || auswahl == 4 || auswahl == 5 || auswahl == 6)) {
                System.out.println("\tKeine Punkte vorhanden");
                main(null);
            }
            else if (auswahl == 2)
                alleAnzeigen();
            else if (auswahl == 3)
                durchschnitt();
            else if (auswahl == 4)
                besteSchlechteste();
            else if (auswahl == 5)
                punktzahlLoeschen();
            else if (auswahl == 6)
                punktzahlAendern();
            else if (auswahl == 0)
                System.out.println("\tProgramm beendet");
        }
    }

    private static void punkteAnzeigen(){
        for (int i = 0; i < punkte.size(); i++) {
            if (punkte.get(i) == 1)
                System.out.println("\t" + (1 + i) + "\t-> " + punkte.get(i) + "\tPunkt");
            else
                System.out.println("\t" + (1 + i) + "\t-> " + punkte.get(i) + "\tPunkte");
        }
    }

    private static void punktzahlEingeben(){
        if (punkte.size()<10) {
            System.out.println("\tBitte Anzahl der Punkte eingeben (0 - 100)");
            int eingabe = sc.nextInt();
            if (eingabe >= 0 && eingabe < 101){
                punkte.add(eingabe);
                System.out.println("\tPunktzahl gespeichert");
                main(null);
            }
            else {
                System.out.println("\tFalsche Eingabe");
                punktzahlEingeben();
            }
        }
        else {
            System.out.println("\tMaximale Anzahl an Einträgen erreicht");
            main(null);
        }
    }

    private static void alleAnzeigen(){
        for (int j = 0; j < punkte.size(); j++) {
            int note = 0;
            if (punkte.get(j) >= 92)
                note = 1;
            else if (punkte.get(j) >= 81)
                note = 2;
            else if (punkte.get(j) >= 67)
                note = 3;
            else if (punkte.get(j) >= 50)
                note = 4;
            else if (punkte.get(j) >= 30)
                note = 5;
            else note = 6;

            if (punkte.get(j) == 1)
                System.out.println("\t" + punkte.get(j) + "\t Punkt -> Note " + note);
            else
                System.out.println("\t" + punkte.get(j) + "\tPunkte -> Note " + note);
        }
        main(null);
    }

    private static void durchschnitt(){
        int punkteGesamt = 0;
        for (int i = 0; i < punkte.size(); i++) {
            punkteGesamt += punkte.get(i);
        }
        double durchschnitt = punkteGesamt / punkte.size();
        if (durchschnitt == 1)
            System.out.println("\tdurchschnittliche Punktzahl: " + durchschnitt + " Punkt");
        else
            System.out.println("\tdurchschnittliche Punktzahl: " + durchschnitt + " Punkte");
        main(null);
    }

    private static void besteSchlechteste() {
        int min = punkte.get(0);
        int max = punkte.get(0);
        for (int i = 0; i < punkte.size(); i++) {
            if (punkte.get(i) > max)
                max = punkte.get(i);
            if (punkte.get(i) < min)
                min = punkte.get(i);
        }
        if (punkte.size() == 1){
            System.out.println("\tNur eine Punktzahl vorhanden: " + punkte.get(0) + " Punkte");
            main(null);
        }
        else {
            System.out.println("\tBeste Punktzahl:\t\t " + max + " Punkte");
            System.out.println("\tSchlechteste Punktzahl:\t " + min + " Punkte");
            main(null);
        }
    }

    private static void punktzahlLoeschen(){
        punkteAnzeigen();
        System.out.println();
        System.out.println("\tWelche Punktzahl soll gelöscht werden? \n\tBitte Nummer eingeben");
        int auswahl = sc.nextInt();
        if (auswahl > 0 && auswahl <= punkte.size()) {
            punkte.remove(auswahl - 1);
            System.out.println("\tPunktzahl gelöscht");
            main(null);
        } else {
            System.out.println("\tBitte nur gültige Nummer wählen\n");
            punktzahlLoeschen();
        }
    }

    private static void punktzahlAendern(){
        punkteAnzeigen();
        System.out.println();
        System.out.println("\tWelche Punktzahl soll geändert werden? \n\tBitte Nummer eingeben");
        int auswahl = sc.nextInt();
        if (auswahl > 0 && auswahl <= punkte.size()) {
            System.out.println("\tBitte neue Punktzahl eingeben");
            int eingabe = sc.nextInt();
            if (eingabe >= 0 && eingabe < 101){
                punkte.set(auswahl - 1, eingabe);
                System.out.println("\tPunktzahl geändert");
                main(null);
            }
            else {
                System.out.println("\tFalsche Eingabe\n");
                punktzahlAendern();
            }
        }
        else {
            System.out.println("\tBitte nur gültige Nummer wählen\n");
            punktzahlAendern();
        }
    }
}