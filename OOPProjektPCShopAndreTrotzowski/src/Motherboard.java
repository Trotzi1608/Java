public class Motherboard extends Produkt{
    private String formfaktor, chipsatz;

    public Motherboard(){}

    public Motherboard(String marke, String modell, double preis, String formfaktor, String chipsatz) {
        super(marke, modell, preis);
        this.formfaktor = formfaktor;
        this.chipsatz = chipsatz;
    }

    public String getFormfaktor() {
        return formfaktor;
    }

    public void setFormfaktor(String formfaktor) {
        this.formfaktor = formfaktor;
    }

    public String getChipsatz() {
        return chipsatz;
    }

    public void setChipsatz(String chipsatz) {
        this.chipsatz = chipsatz;
    }

    @Override
    public String toString() {
        return "\tMotherboard\n" + super.toString() +"\n\t\tFormfaktor:\t"
                + formfaktor + "\n\t\tChipsatz:\t" + chipsatz;
    }
}