public class PizzaMeine {
    static double[] preis;
    static String[] name;

    static {
        preis = new double[5];
        preis[0] = 7.99;  // Pizza-Hawaii
        preis[1] = 5.89;  // Pizza Margherita
        preis[2] = 8.49;  // Pizza Salami
        preis[3] = 6.49;  // Mozzarella-Gorgonzola-Pizza
        preis[4] = 9.29;  // Pizza Meeresfrüchte

        name = new String[5];
        name[0] = "Pizza-Hawaii";
        name[1] = "Pizza Margherita";
        name[2] = "Pizza Salami";
        name[3] = "Mozzarella-Gorgonzola-Pizza";
        name[4] = "Pizza Meeresfrüchte";
    }

    public static void main(String[] args) {
        getMenu();
    }

    public static void pizzeriaAufgabe1() {
        System.out.println("Eine Pizza Margherita kostet " + preis[1] + "€.");

        double einkauf;
        einkauf = preis[0] + preis[2] + 2 * preis[3];
        System.out.println("Eine Pizza Hawaii und eine Pizza Salami sowie zwei Mozzarella-Gorgonzola-Pizzen" +
                " kosten insgesamt " + einkauf + "€.");

        // Pizza Meeresfrüchte wird 10 % günstiger angeboten.
        // Berechne den neuen Preis und speichere ihn im Feld. (**)
        // ...
        double reduzierterPreis = (double) Math.round((0.9 * preis[4]) * 100) / 100;
        System.out.println("Eine Pizza Meeresfrüchte mit 10% Rabatt kostet " + reduzierterPreis + "€.");
    }

    public static void getMenu() {
        System.out.println("Menü der Pizzeria Meine:");
        for (int i = 0; i < preis.length; i++) {
            System.out.println((i + 1) + ". " + name[i] + " - " + preis[i] + "€");
        }
    }
}
