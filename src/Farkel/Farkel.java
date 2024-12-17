package Farkel;

public class Farkel {
    private final Wuerfel[] wuerfelSet;
    private final int anzahlDerSpieler;
    private int aktuellerSpieler;
    private int aktuellePunktzahl;

    public Farkel(int anzahlDerSpieler) {
        this.anzahlDerSpieler = anzahlDerSpieler;
        this.aktuellerSpieler = 0;
        this.aktuellePunktzahl = 0;
        this.wuerfelSet = new Wuerfel[6];
        for (int i = 0; i < 6; i++) {
            this.wuerfelSet[i] = new Wuerfel(6);
        }
    }

    public void wuerfeln() {
        for (Wuerfel w : this.wuerfelSet) {
            w.wuerfeln();
        }
    }

    public boolean pruefeFuenfenEinsen() {
        for (Wuerfel w : this.wuerfelSet) {
            int augenzahl = w.gibAugenzahl();
            if (augenzahl == 1 || augenzahl == 5) {
                return true;
            }
        }
        return false;
    }

    public int gibAnzahlDerSpieler() {
        return this.anzahlDerSpieler;
    }

    public int gibAktuellerSpieler() {
        return this.aktuellerSpieler;
    }

    public int gibAktuellePunktzahl() {
        return this.aktuellePunktzahl;
    }

    public Wuerfel[] gibWuerfelSet() {
        return this.wuerfelSet;
    }

    public void method() {
    }
}
