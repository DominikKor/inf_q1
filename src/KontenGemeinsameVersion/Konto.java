package KontenGemeinsameVersion;

/**
 * Beschreiben Sie hier die Klasse Konto.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Konto
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private boolean freigeschaltet;
    private String pin;
    private int abhebeLimit;
    private double kontoStand;
    private double heuteAbgehoben;

    public Konto(String pPin, int pAbhebeLimit)
    {
        pin = pPin; // Erläutere den Sinn dieser Wertzuweisung.
        // Hintergrundwissen, Fachbegriffe, (Beispiel)
        // Fachbegriffe nennen check
        // Fachbegriffe erläutern check
        // auf den Gültigkeitsbereich eingehen check
        abhebeLimit = pAbhebeLimit;
    }

    public void geldEinzahlen(int betrag)
    {
        if (betrag > 0)
        {
            kontoStand += betrag;
        }
    }

    /*
    public boolean pinNummerEingeben(String pinEingabe)
    {
    if (pinEingabe.equals(pin))
    {
    freigeschaltet = true;
    return true;
    }
    else
    {
    freigeschaltet = false;
    return false;
    }
    } */

    public boolean pinNummerEingeben(String pinEingabe)
    {
        freigeschaltet = pin.equals(pinEingabe);
        return freigeschaltet;
    }

    public void geldAbheben(int betrag)
    {
        if (betrag > 0 && kontoStand >= betrag && abhebeLimit >= betrag + heuteAbgehoben && freigeschaltet)
        {
            kontoStand -= betrag;
            freigeschaltet = false;
            heuteAbgehoben += betrag;
        }
        else
        {
            System.out.println("Fehler beim Abheben!");
        }
    }

    public double gibKontoStand()
    {
        if (freigeschaltet)
        {
            return kontoStand;
        }
        System.out.println("Kontostand ist nicht freigeschaltet.");
        return -1;
    }

    public int gibAbhebeLimit()
    {
        return abhebeLimit;
    }

    public void neuerTag()
    {
        heuteAbgehoben = 0;
    }
}
