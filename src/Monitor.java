public class Monitor extends Produkt{
    private double groesse;

    public Monitor(){}

    public Monitor(String marke, String modell, double preis, double groesse) {
        super(marke, modell, preis);
        this.groesse = groesse;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    @Override
    public String toString() {
        return "\tMonitor\n" + super.toString() + "\n\t\tGröße:\t" + groesse + " Zoll";
    }
}