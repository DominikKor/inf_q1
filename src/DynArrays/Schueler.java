package DynArrays;

public class Schueler extends Person {
    private final String schuelerID;
    private final String geschlecht;

    private int alter;
    private Tutor tutor;

    public Schueler(String schuelerID, String vorname, String nachname, String geschlecht, int alter, Tutor tutor) {
        super(vorname, nachname);
        this.schuelerID = schuelerID;
        this.geschlecht = geschlecht;
        this.alter = alter;
        this.tutor = tutor;
    }

     public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getSchuelerID() {
        return this.schuelerID;
    }

    public String getGeschlecht() {
        return this.geschlecht;
    }

    public int getAlter() {
        return this.alter;
    }

    public Tutor getTutor() {
        return this.tutor;
    }
}
