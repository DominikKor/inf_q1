public class MagenfreundlicheMensaMeine {
    /*
     * Willkommen im Restaurant MagenfreundlicheMensaMeine!
     * Unser Menü:
     * 	1.	Rote Nudeln - 12,99€
     *  2.	Grüne Gemüsepfanne - 9,49€
     *  3.	Gelbe Curry-Linsen - 8,79€
     *  4.	Bunte Quinoa-Bowl - 11,29€
     *  5.	Weiße Tomaten-Mozzarella-Pizza - 13,49€
     *  6.	Goldene Hähnchenbrust mit Honig-Senf-Soße - 14,99€
     *  7.	Schwarzer Bohnen-Burger - 10,99€
     */

    static double[] preis;
    static String[] name;

    static {
        preis = new double[7];
        preis[0] = 12.99;  // Rote Nudeln
        preis[1] = 9.49;   // Grüne Gemüsepfanne
        preis[2] = 8.79;   // Gelbe Curry-Linsen
        preis[3] = 11.29;  // Bunte Quinoa-Bowl
        preis[4] = 13.49;  // Weiße Tomaten-Mozzarella-Pizza
        preis[5] = 14.99;  // Goldene Hähnchenbrust mit Honig-Senf-Soße
        preis[6] = 10.99;  // Schwarzer Bohnen-Burger

        name = new String[7];
        name[0] = "Rote Nudeln";
        name[1] = "Grüne Gemüsepfanne";
        name[2] = "Gelbe Curry-Linsen";
        name[3] = "Bunte Quinoa-Bowl";
        name[4] = "Weiße Tomaten-Mozzarella-Pizza";
        name[5] = "Goldene Hähnchenbrust mit Honig-Senf-Soße";
        name[6] = "Schwarzer Bohnen-Burger";
    }

    public static void main(String[] args) {
        bestellung();
    }

    public static void beispieleAufgabe2() {
        double einkauf1 = preis[0] + preis[2] + 2 * preis[3];
        System.out.println(
            "Einmal " + name[0] + " und " +
            "einmal " + name[2] + " sowie " +
            "zwei " + name[3] + "s " +
            "kosten insgesamt " + einkauf1 + "€."
        );

        double einkauf2 = 3 * preis[5] + preis[1] + preis[6];
        System.out.println(
            "Dreimal " + name[5] + " und " +
            "eine " + name[1] + " sowie" +
            "ein " + name[6] + " " +
            "kosten insgesamt " + einkauf2 + "€."
        );

        double einkauf3 = preis[4] + 4 * preis[2] + preis[0];
        System.out.println(
            "Eine " + name[4] + " und " +
            "vier Mal " + name[2] + " sowie " +
            "einmal " + name[0] + " " +
            "kosten insgesamt " + einkauf3 + "€."
        );
    }

    public static void getMenu() {
        System.out.println("Menü der MagenfreundlichenMensaMeine:");
        for (int i = 0; i < preis.length; i++) {
            System.out.println((i + 1) + ". " + name[i] + " - " + preis[i] + "€");
        }
    }

    public static void bestellung() {
        int[] bestellung = {0, 2, 2, 1, 0, 6, 0};
        // int[] bestellung = {3, 0, 1, 0, 0, 0, 2};

        double total = 0;

        for (int i = 0; i < bestellung.length; i++) {
            int anzahl = bestellung[i];
            if (anzahl == 0) {
                continue;
            }

            double gesamtPreis = anzahl * preis[i];
            total += gesamtPreis;
            System.out.println(anzahl + "x " + name[i] + " für insgesamt " + gesamtPreis + "€ zur Bestellung hinzugefügt.");
        }

        // total für schönere Darstellung runden.
        total = (double) (Math.round(total * 100)) / 100;

        System.out.println("Der Gesamtpreis der Bestellung liegt bei " + total + "€.");
        System.out.println("Vielen Dank!");
    }
}
