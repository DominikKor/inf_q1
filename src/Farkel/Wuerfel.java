package Farkel;

public class Wuerfel {
    private final int anzahlSeiten;
    private int augenzahl;
    private boolean gewuerfelt;

    public Wuerfel(int anzahlSeiten) {
        this.anzahlSeiten = anzahlSeiten;
        this.gewuerfelt = false;
        this.augenzahl = -1;
    }

    public void wuerfeln() {
        this.augenzahl = (int) (Math.random() * this.anzahlSeiten) + 1;
        this.gewuerfelt = true;
    }

    public boolean gibGewuerfelt() {
        return this.gewuerfelt;
    }

    public int gibAugenzahl() {
        return this.augenzahl;
    }

    public int gibAnzahlSeiten() {
        return this.anzahlSeiten;
    }
}
