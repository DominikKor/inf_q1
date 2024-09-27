package EinfuehrungKlassen;

public class Haupt {
    public static void main(String[] args) {
        Berechnung berechnung = new Berechnung();
        double quadrat = berechnung.quadratBerechnen(4.2);

        System.out.println(quadrat);
    }
}
