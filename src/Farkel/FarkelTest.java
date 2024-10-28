package Farkel;

public class FarkelTest {
    public static void main(String[] args) {
        Farkel spiel = new Farkel(2);
        spiel.wuerfeln();

        if (spiel.pruefeFuenfenEinsen()) {
            System.out.println("Es wurde mindestens eine Fünf oder Eins gewürfelt!");
        } else {
            System.out.println("Keine Fünf oder Eins gewürfelt.");
        }
    }
}