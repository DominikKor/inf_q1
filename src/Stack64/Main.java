package Stack64;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Stack<String> colors1 = new Stack<String>();
        colors1.push("violett23");
        colors1.push("rot1");
        colors1.push("gelb3");
        colors1.push("gruen2");
        colors1.push("rot4");
        Stack<String> colors2 = new Stack<String>();
        colors2.push("violett22");
        colors2.push("gruen3");
        colors2.push("gelb1");
        colors2.push("rot2");
        Stack<String>[] allColors = new Stack[2];
        allColors[0] = colors1;
        allColors[1] = colors2;
        sortiereNachFarben(allColors);

        /*Stack<Character> stack = inZeichenAufteilen("portal");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }*/
    }

    public static void sortiereNachFarben(Stack<String>[] s) {
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();

        int anzahlStacks = 0;
        for (Stack<String> stack : s) {
            while (!stack.isEmpty()) {
                anzahlStacks++;
                stack1.push(stack.pop());
            }
        }

        String[] uniqueColors = new String[anzahlStacks];

        int totalColors = 0;
        while (!stack1.isEmpty()) {
            boolean colorExists = false;
            for (String color : uniqueColors) {
                if (stack1.top().replaceAll("[0-9]", "").equals(color)) {
                    colorExists = true;
                    break;
                }
            }

            if (!colorExists) {
                uniqueColors[totalColors] = stack1.top().replaceAll("[0-9]", "");
                totalColors++;
            }

            stack2.push(stack1.pop());

        }

        int counter = 0;
        for (String color : uniqueColors) {
            if (color == null) {
                break;
            }
            counter++;
        }

        Stack<String>[] sorted = new Stack[counter];
        for (int i = 0; i < counter; i++){
            sorted[i] = new Stack<String>();
        }

        String[] sortedColors = new String[counter];
        for (String colorI : uniqueColors) {
            if (colorI == null) {
                break;
            }
            int colorCounter = 0;
            for (String colorJ : uniqueColors) {
                if (colorJ == null) {
                    break;
                }
                int compare = colorI.compareTo(colorJ);
                if (compare > 0) {
                    colorCounter++;
                }
            }
            sortedColors[colorCounter] = colorI;
        }

        System.out.println(Arrays.toString(sortedColors));
        System.out.println(counter);

        while (!stack2.isEmpty()) {
            for (int i = 0; i < counter; i++) {
                if (sortedColors[i].equals(stack2.top().replaceAll("[0-9]", ""))) {
                    sorted[i].push(stack2.pop());
                }
            }
        }

        for (int i = 0; i < counter; i++) {
            sorted[i] = sortStringStackAlphabetically(sorted[i]);
        }

        for (int i = 0; i < counter; i++) {
            Stack<String> stack = sorted[i];
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
            System.out.println("-");
        }
    }

    public static Stack<String> sortStringStackAlphabetically(Stack<String> stack) {
        Stack<String> tempStack = new Stack<String>();

        while (true) {
            tempStack.push(stack.pop());
            String top = stack.pop();
            if (top == null) {
                break;
            }

            if (getNumber(top) < getNumber(tempStack.top())) {
                stack.push(tempStack.pop());
            }

            tempStack.push(top);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stack;
    }

    public static Integer getNumber(String s) {
        return Integer.parseInt(s.replaceAll("[^0-9]", ""));
    }









    public static Stack<Character> inZeichenAufteilen(String text) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = text.length(); i > 0; i--) {
            stack.push(text.charAt(i-1));
        }
        return stack;
    }
}
