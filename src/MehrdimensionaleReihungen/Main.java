package MehrdimensionaleReihungen;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        temperature();
    }

    public static void temperature() {
        double[][] temperatures = new double[7][24];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < temperatures[0].length; j++) {
                temperatures[i][j] = (double) ((int) (Math.random() * 26 * 100)) / 100;
            }
        }

        System.out.println(Arrays.deepToString(temperatures));

        double minTemp = 26;
        double maxTemp = -1;
        int minHour = -1;
        int minDay = -1;
        int maxHour = -1;
        int maxDay = -1;
        double weeklyTotal = 0;
        double eightAmTotal = 0;
        double twelvePmTotal = 0;
        double sixPmTotal = 0;
        for (int i = 0; i < temperatures.length; i++) {
            double dailyTotal = 0;
            for (int j = 0; j < temperatures[0].length; j++) {
                double temperature = temperatures[i][j];
                dailyTotal += temperature;
                if (temperature < minTemp) {
                    minTemp = temperature;
                    minHour = j;
                    minDay = i;
                }
                if (temperature > maxTemp) {
                    maxTemp = temperature;
                    maxHour = j;
                    maxDay = i;
                }
                if (j == 7) {
                    eightAmTotal += temperature;
                }
                if (j == 11) {
                    twelvePmTotal += temperature;
                }
                if (j == 17) {
                    sixPmTotal += temperature;
                }
            }
            weeklyTotal += dailyTotal;
            System.out.println("Für Tag " + (i + 1) + ": " + dailyTotal / temperatures[0].length + "°C.");
        }
        System.out.println("Für die Woche: " + weeklyTotal / (temperatures.length * temperatures[0].length) + "°C.");
        System.out.println("Kühlste: Stunde " + minHour + " an Tag " + (minDay + 1) + " mit " + minTemp + "°C.");
        System.out.println("Wärmste: Stunde " + maxHour + " an Tag " + (maxDay + 1) + " mit " + maxTemp + "°C.");
        System.out.println("Durchschnitt der Woche um 8 Uhr: " + (eightAmTotal / temperatures.length) + "°C.");
        System.out.println("Durchschnitt der Woche um 12 Uhr: " + (twelvePmTotal / temperatures.length) + "°C.");
        System.out.println("Durchschnitt der Woche um 18 Uhr: " + (sixPmTotal / temperatures.length) + "°C.");
    }
}
