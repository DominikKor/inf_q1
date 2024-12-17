package DynArrays;

public class Main {
    public static void main(String[] args) {
        DynArray<Schueler> schuelerListe = new DynArray<>();
        DynArray<Tutor> tutorListe = new DynArray<>();

        Tutor tutor1 = new Tutor("Mu", "Max", "Mustermann", "Mathe", "Physik");
        Tutor tutor2 = new Tutor("Pe", "Peter", "Peters", "Deutsch", "Englisch");
        Tutor tutor3 = new Tutor("Sc", "Emil", "Schreiber", "Geschichte", "Politik");
        tutorListe.append(tutor1);
        tutorListe.append(tutor2);
        tutorListe.append(tutor3);

        schuelerListe.append(new Schueler("1", "Lukas", "Weber", "m", 14, tutor1));
        schuelerListe.append(new Schueler("2", "Sophie", "Keller", "w", 15, tutor3));
        schuelerListe.append(new Schueler("3", "Nico", "Schwarz", "m", 16, tutor2));
        schuelerListe.append(new Schueler("4", "Mia", "Fischer", "w", 13, tutor1));
        schuelerListe.append(new Schueler("5", "Leon", "Becker", "m", 17, tutor3));
        schuelerListe.append(new Schueler("6", "Clara", "Hoffmann", "w", 12, tutor3));
        schuelerListe.append(new Schueler("7", "Finn", "Meyer", "m", 18, tutor2));
        schuelerListe.append(new Schueler("8", "Emily", "Schulz", "w", 14, tutor2));
        schuelerListe.append(new Schueler("9", "Tim", "Baumann", "m", 19, tutor3));
        schuelerListe.append(new Schueler("10", "Jana", "Wolf", "w", 16, tutor1));

        Schueler schueler = suche(schuelerListe, tutor1);
        DynArray<Schueler> schuelerListeTutor1 = sucheAlle(schuelerListe, tutor1);
        DynArray<DynArray<Schueler>> sortierteListe = sortAllStudentsByTutor(schuelerListe, tutorListe);

        System.out.println("--------------------");

        if (schueler != null) {
            System.out.println("Schueler von Tutor 1: " + schueler.getVorname() + " " + schueler.getNachname());
        }

        System.out.println("--------------------");

        if (schuelerListeTutor1 != null) {
            System.out.println("Schueler von Tutor 1:");
            for (int i = 0; i < schuelerListeTutor1.getLength(); i++) {
                Schueler s = schuelerListeTutor1.getItem(i);
                System.out.println(s.getVorname() + " " + s.getNachname());
            }
        }

        System.out.println("--------------------");

        if (sortierteListe != null) {
            System.out.println("Sortierte Liste:");
            for (int i = 0; i < sortierteListe.getLength(); i++) {
                System.out.println("---");
                DynArray<Schueler> sList = sortierteListe.getItem(i);
                System.out.println("Tutor: " + tutorListe.getItem(i).getVorname() + " " + tutorListe.getItem(i).getNachname());
                for (int j = 0; j < sList.getLength(); j++) {
                    Schueler s = sList.getItem(j);
                    System.out.println(s.getVorname() + " " + s.getNachname());
                }
            }
        }
    }


    public static Schueler suche(DynArray<Schueler> schuelerListe, Tutor tutor) {
        for (int i = 0; i < schuelerListe.getLength(); i++) {
            Schueler schueler = schuelerListe.getItem(i);
            if (schueler.getTutor().equals(tutor)) {
                return schueler;
            }
        }
        return null;
    }

    public static DynArray<Schueler> sucheAlle(DynArray<Schueler> schuelerDynArray, Tutor tutor) {
        DynArray<Schueler> schuelerListe = new DynArray<>();
        for (int i = 0; i < schuelerDynArray.getLength(); i++) {
            Schueler schueler = schuelerDynArray.getItem(i);
            if (schueler.getTutor().equals(tutor)) {
                schuelerListe.append(schueler);
            }
        }
        if (schuelerListe.getLength() == 0) {
            return null;
        }
        return schuelerListe;
    }

    public static DynArray<DynArray<Schueler>> sortAllStudentsByTutor(DynArray<Schueler> schuelerListe, DynArray<Tutor> tutorListe) {
        DynArray<DynArray<Schueler>> sortierteListe = new DynArray<>();
        for (int i = 0; i < tutorListe.getLength(); i++) {
            Tutor tutor = tutorListe.getItem(i);
            DynArray<Schueler> sortedStudents = Main.sucheAlle(schuelerListe, tutor);
            sortierteListe.append(sortedStudents);
        }
        if (sortierteListe.getLength() == 0) {
            return null;
        }
        return sortierteListe;
    }
}
