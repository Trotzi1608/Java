public class Maus extends Produkt{
    private boolean kabelgebunden;

    public Maus(){}

    public Maus(String marke, String modell, double preis, boolean kabelgebunden) {
        super(marke, modell, preis);
        this.kabelgebunden = kabelgebunden;
    }

    public boolean getKabelgebunden() {
        return kabelgebunden;
    }

    public void setKabelgebunden(boolean kabelgebunden) {
        this.kabelgebunden = kabelgebunden;
    }

    public String toString() {
        String kabel = "";
        if (kabelgebunden == true)
            kabel = "ja";
        else
            kabel = "nein";
        return "\tMaus\n" + super.toString() + "\n\t\tkabelgebunden:\t" + kabel;
    }
}