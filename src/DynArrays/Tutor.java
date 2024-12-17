package DynArrays;

public class Tutor extends Person {
    private final String kuerzel;

    private String fach1;
    private String fach2;

    public Tutor(String kuerzel, String vorname, String nachname, String fach1, String fach2) {
        super(vorname, nachname);
        this.kuerzel = kuerzel;
        this.fach1 = fach1;
        this.fach2 = fach2;
    }

    public String getKuerzel() {
        return this.kuerzel;
    }

    public String getFach1() {
        return this.fach1;
    }

    public void setFach1(String fach1) {
        this.fach1 = fach1;
    }

    public String getFach2() {
        return this.fach2;
    }

    public void setFach2(String fach2) {
        this.fach2 = fach2;
    }
}
