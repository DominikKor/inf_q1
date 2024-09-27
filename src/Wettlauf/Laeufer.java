package Wettlauf;

public class Laeufer implements Comparable<Laeufer> {
    private String name;
    private double zeit;
    private boolean qualifiziert;

    public Laeufer(String name, boolean qualifiziert) {
        this.name = name;
        this.qualifiziert = qualifiziert;
    }

    public String gibName() {
        return name;
    }

    public void setzeName(String name) {
        this.name = name;
    }

    public double gibZeit() {
        return zeit;
    }

    public void setzeZeit(double zeit) {
        this.zeit = zeit;
    }

    public boolean gibQualifiziert() {
        return qualifiziert;
    }

    public void setzeQualifiziert(boolean qualifiziert) {
        this.qualifiziert = qualifiziert;
    }

    @Override
    public int compareTo(Laeufer laeufer) {
        return (int) (this.zeit - laeufer.zeit) * 100;
    }

    @Override
    public String toString() {
        return "Laeufer(\"" + this.name + "\", " + this.zeit + "\", " + (this.qualifiziert ? "" : "dis") + "qualifiziert)";
    }
}
