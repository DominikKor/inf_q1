package Wettlauf;

import java.util.Arrays;

public class Wettlauf {
    private Laeufer[] laeuferfeld;

    public Wettlauf(Laeufer[] laeuferfeld) {
        this.laeuferfeld = laeuferfeld;
    }

    public Laeufer[] getLaeuferfeld() {
        return laeuferfeld;
    }

    public void setLaeuferfeld(Laeufer[] laeuferfeld) {
        this.laeuferfeld = laeuferfeld;
    }

    public static void main(String[] args) {
        Wettlauf wettlauf = new Wettlauf(new Laeufer[] {
            new Laeufer("Gerhard Schröder", true),
            new Laeufer("Tim Weber", true),
            new Laeufer("Peter Pan", true),
            new Laeufer("Gertrud Tanz", true),
            new Laeufer("Sos Los Fos", true),
            new Laeufer("Maria Maria", true),
            new Laeufer("Julius Caesar", true),
            new Laeufer("Sabine Bein", true),
        });

        wettlauf.rennenLaufen();
        System.out.println(wettlauf.gibSchnellstenLaeufer());
        System.out.println(wettlauf.gibLangsamstenLaeufer());
        System.out.println(wettlauf.gibDurchschnittsZeit());
    }

    public void anDenStart(int bahn, Laeufer laeufer) {
        laeuferfeld[bahn] = laeufer;
    }

    public static double zeitMessen() {
        return 10 + ((double) ((int) (Math.random() * 1000)) / 100);
    }

    public void rennenLaufen() {
        for (Laeufer laeufer : this.laeuferfeld) {
            if (!laeufer.gibQualifiziert()) {
                System.out.println("Eine Person ist nicht qualifiziert! Das Rennen kann nicht stattfinden.");
                return;
            }
            laeufer.setzeZeit(zeitMessen());
        }

        Arrays.sort(this.laeuferfeld);

        for (int i = 0; i < this.laeuferfeld.length; i++) {
            this.laeuferfeld[i].setzeQualifiziert(i <= 1);
        }

        System.out.println(Arrays.toString(this.laeuferfeld));
    }

    public Laeufer gibSchnellstenLaeufer() {
        Arrays.sort(this.laeuferfeld);
        return this.laeuferfeld[0];
    }

    public Laeufer gibLangsamstenLaeufer() {
        Arrays.sort(this.laeuferfeld);
        return this.laeuferfeld[this.laeuferfeld.length - 1];
    }

    public double gibDurchschnittsZeit() {
        double summe = 0;
        for (Laeufer laeufer : this.laeuferfeld) {
            summe += laeufer.gibZeit();
        }
        return summe / this.laeuferfeld.length;
    }
}
