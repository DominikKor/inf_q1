package KontenGemeinsameVersion;

/**
 * Beschreiben Sie hier die Klasse Haupt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Haupt
{
    public static void main(String[] args)
    {
        Konto konto1 = new Konto("1234", 500);
        konto1.geldEinzahlen(1000);
        
        // Tag 1
        konto1.pinNummerEingeben("1234");
        konto1.geldAbheben(50);
        konto1.pinNummerEingeben("1234");
        System.out.println(konto1.gibKontoStand());
        
        // Tag 2
        Konto konto2 = new Konto("5678", 1000);
        konto2.geldEinzahlen(50);
        
        Konto[] konten = new Konto[2];
        konten[0] = konto1;
        konten[1] = konto2;
        
        // Ermittelt die Summe des Abhebelimits.
        int summe = 0;
        for (int i = 0; i < 2; i++)
        {
            summe += konten[i].gibAbhebeLimit();
        }

        System.out.println(summe);

        konten[0].pinNummerEingeben("1234");
        konten[1].pinNummerEingeben("5678");
        System.out.println(ermittleKontostand(konten));


        // summe ist nur in der main-Methode der Klasse Haupt gültig, ab seiner Definition in Zeile 31.
        // i ist nur in der for-Schleife gültig, d. h. nur in Zeile 34.
        // Das übergebene Argument betrag ist nur innerhalb der Methode als betrag gültig (geldAbheben, geldEinzahlen)
        // pin ist ein Attribut, was in allen Methoden des Objekts gültig ist, solange es besteht.
    }

    public static double ermittleKontostand(Konto[] konten) {
        double summe = 0;
        for (Konto konto : konten) {
            summe += konto.gibKontoStand();
        }
        return summe;
    }

    public static void spenden(Konto[] konten, double spendenHoehe) {

    }
}
