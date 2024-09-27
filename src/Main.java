import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        arrayTestHA();
    }

    /*
     * Die Methode gibAnzahl(zahlen : Ganzzahl[], von, bis : Ganzzahl) : Ganzzahl
     *  ermittelt die Anzahl der Elemente in der Reihung zahlen, die sich im Intervall [von; bis] befinden.
     * Die Methode berechneSpannweite(zahlen : Fließkommazahl[]) : Fließkommazahl
     *  ermittelt den größten und kleinsten Wert der Reihung zahlen.
     *  Die Spannweite ist die Differenz vom Maximum und Minimum.
     *  Die Methode berechneSpannweite gibt diesen Wert zurück.
     */

    public static int gibAnzahl(int[] zahlen, int von, int bis) {
        int counter = 0;
        for (int zahl : zahlen) {
            counter += (zahl >= von && zahl <= bis) ? 1 : 0;
        }
        return counter;
    }

    public static double berechneSpannweite(double[] zahlen) {
        double highest = zahlen[0];
        double lowest = zahlen[0];
        for (double i : zahlen) {
            if (i > highest) {
                highest = i;
            }
            if (i < lowest) {
                lowest = i;
            }
        }

        return highest - lowest;
    }

    public static void arrayTestHA() {
        System.out.println(gibAnzahl(new int[]{-2, -17, 4, 7, 12, 2, 5}, 3, 7));
        System.out.println(berechneSpannweite(new double[]{1, -114.12, -20.20, 2.71, 200.039, 15, 0}));
    }

    public static void kontoTest() {
        Konto konto = new Konto("1234", 200);

        konto.geldEinzahlen(500);
        konto.geldAbheben(100);
        konto.pinNummerEingeben("4321");
        konto.geldAbheben(100);
        konto.pinNummerEingeben("1234");
        konto.geldAbheben(100);

        konto.gibKontoStand();
        konto.pinNummerEingeben("1234");
        System.out.println(konto.gibKontoStand());

        konto.pinNummerEingeben("1234");
        System.out.println(konto.gibAbhebeLimit());

        konto.pinNummerEingeben("1234");
        konto.geldAbheben(200);

        konto.pinNummerEingeben("1234");
        konto.geldAbheben(300);

        konto.pinNummerEingeben("1234");
        konto.geldAbheben(200);

        konto.pinNummerEingeben("0000");
        konto.pinNummerEingeben("0000");
        konto.pinNummerEingeben("0000");
        konto.pinNummerEingeben("4321");
        konto.geldAbheben(100);
    }

    public static void arrayTest() {
        // System.out.println(Arrays.toString(calculateFibonacci(20)));
        System.out.println(zweihundertMalWuerfeln());

        int[] note = new int[6];
        note[0] = 15;
        note[1] = 12;
        note[2] = 9;
        note[3] = 4;
        note[3] += 2;

        for (int i = 0; i < note.length; i++) {
            System.out.println("Note " + i + ": " + note[i]);
        }
    }

    public static double berechneQuadratzahl(double zahl) {
        return zahl * zahl;
    }

    public static double berechneMaximum(double a, double b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public static double berechneHypotenuse(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static int[] fuenfMalWuerfeln() {
        Random r = new Random();
        int[] results = new int[5];

        for (int i = 0; i < results.length; i++) {
            results[i] = r.nextInt(6) + 1;
        }

        return results;
    }

    public static double zweihundertMalWuerfeln() {
        Random r = new Random();
        int[] results = new int[200];

        for (int i = 0; i < results.length; i++) {
            results[i] = r.nextInt(100) + 1;
        }

        int sum = arraySum(results);
        double average = (double) sum / results.length;

        printHighestAndLowest(results);

        return average;
    }

    public static int arraySum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static void printHighestAndLowest(int[] array) {
        int highest = 0;
        int lowest = 100;
        for (int i : array) {
            if (i > highest) {
                highest = i;
            }
            if (i < lowest) {
                lowest = i;
            }
        }
        System.out.println(highest);
        System.out.println(lowest);
    }

    public static int[] multiplesOfN(int n, int countMultiples) {
        int[] result = new int[countMultiples];

        for (int i = 0; i < countMultiples; i++) {
            result[i] = 9 * (i + 1);
        }

        return result;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int[] calculateFibonacci(int n) {
        int[] fibonacciNumbers = new int[n];

        for (int i = 0; i < 20; i++) {
            fibonacciNumbers[i] = fibonacci(i);
        }

        return fibonacciNumbers;
    }

    public static int anzahlZuLang(String[] namen) {
        int nameCounter = 0;
        for (String name : namen) {
            if (name.length() >= 21) {
                nameCounter++;
            }
        }
        return nameCounter;
    }

    public static double abc() {
        int a =  4;
        return (double) a / 2;
    }
}
