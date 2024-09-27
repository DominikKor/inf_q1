public class Konto {
    private boolean freigeschaltet;
    private final String pin;
    private final int abhebeLimit;
    private double kontoStand;
    private boolean kontoGesperrt;
    private int pinFehlversuche;

    public Konto(String pin, int abhebeLimit) {
        this.pin = pin;
        this.abhebeLimit = abhebeLimit;

        kontoStand = 0;
        freigeschaltet = false;
        kontoGesperrt = false;
        pinFehlversuche = 0;
    }

    public void geldAbheben(double betrag) {
        if (kontoGesperrt) {
            System.out.println("Ihr Konto ist gesperrt.");
            System.out.println("Bitte wenden Sie sich an Ihre Bank, um Ihr Konto wieder zu entsperren.");
            return;
        }

        if (!freigeschaltet) {
            System.out.println("Konto ist nicht freigeschaltet. Bitte PIN eingeben.");
            return;
        }
        freigeschaltet = false;

        if (betrag <= 0) {
            System.out.println("Bitte geben Sie einen positiven Betrag ein.");
            return;
        }

        if (betrag > abhebeLimit) {
            System.out.println("Betrag übersteigt Abhebelimit.");
            return;
        }

        if (betrag > kontoStand) {
            System.out.println("Konto ist nicht genug gedeckt.");
            return;
        }

        System.out.println(betrag + "€ ausgegeben.");
    }

    public void geldEinzahlen(double betrag) {
        if (kontoGesperrt) {
            System.out.println("Ihr Konto ist gesperrt.");
            System.out.println("Bitte wenden Sie sich an Ihre Bank, um Ihr Konto wieder zu entsperren.");
            return;
        }

        if (betrag <= 0) {
            System.out.println("Bitte geben Sie einen positiven Betrag ein.");
            return;
        }

        kontoStand += betrag;

        System.out.println(betrag + "€ eingezahlt.");
    }

    public boolean pinNummerEingeben(String pinEingabe) {
        if (kontoGesperrt) {
            System.out.println("Ihr Konto ist gesperrt.");
            System.out.println("Bitte wenden Sie sich an Ihre Bank, um Ihr Konto wieder zu entsperren.");
            return false;
        }

        if (!pinEingabe.equals(pin)) {
            System.out.println("Falsche PIN. Bitte erneut versuchen.");

            pinFehlversuche += 1;
            if (pinFehlversuche >= 3) {
                kontoGesperrt = true;
                System.out.println("Sie haben Ihre PIN drei Mal falsch eingegeben und Ihr Konto wurde gesperrt.");
                System.out.println("Bitte wenden Sie sich an Ihre Bank, um Ihr Konto wieder zu entsperren.");
            }

            return false;
        }
        freigeschaltet = true;
        pinFehlversuche = 0;
        return true;
    }

    public double gibKontoStand() {
        if (kontoGesperrt) {
            System.out.println("Ihr Konto ist gesperrt.");
            System.out.println("Bitte wenden Sie sich an Ihre Bank, um Ihr Konto wieder zu entsperren.");
            return -1;
        }

        if (!freigeschaltet) {
            System.out.println("Konto ist nicht freigeschaltet. Bitte PIN eingeben.");
            return -1;
        }
        freigeschaltet = false;

        return kontoStand;
    }

    public double gibAbhebeLimit() {
        if (kontoGesperrt) {
            System.out.println("Ihr Konto ist gesperrt.");
            System.out.println("Bitte wenden Sie sich an Ihre Bank, um Ihr Konto wieder zu entsperren.");
            return -1;
        }

        if (!freigeschaltet) {
            System.out.println("Konto ist nicht freigeschaltet. Bitte PIN eingeben.");
            return -1;
        }
        freigeschaltet = false;

        return abhebeLimit;
    }
}
