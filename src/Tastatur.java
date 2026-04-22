public class Tastatur extends Produkt{
    private int anzahlTasten;
    private boolean beleuchtet;

    public Tastatur(){}

    public Tastatur(String marke, String modell, double preis, int anzahlTasten, boolean beleuchtet) {
        super(marke, modell, preis);
        this.anzahlTasten = anzahlTasten;
        this.beleuchtet = beleuchtet;
    }

    public int getAnzahlTasten() {
        return anzahlTasten;
    }

    public void setAnzahlTasten(int anzahlTasten) {
        this.anzahlTasten = anzahlTasten;
    }

    public boolean getBeleuchtet() {
        return beleuchtet;
    }

    public void setBeleuchtet(boolean beleuchtet) {
        this.beleuchtet = beleuchtet;
    }

    public String toString() {
        String leuchtet = "";
        if (beleuchtet == true)
            leuchtet = "ja";
        else leuchtet = "nein";
        return "\tTastatur\n" + super.toString() + "\n\t\tAnzahl Tasten:\t"
                + anzahlTasten + "\n\t\tbeleuchtet:\t" + leuchtet;
    }
}