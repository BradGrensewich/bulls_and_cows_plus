package bullscows;

import java.util.Random;

public class CodeMaker {
    private int size;
    private int range;

    public CodeMaker(int size, int range) {
        this.size = size;
        this.range = range;
    }

    public String createCode() {
        StringBuilder sb = new StringBuilder();
        Random rng = new Random();
        char charToAdd;
        while (sb.length() < this.size) {
            int toAdd = rng.nextInt(this.range);
            if (toAdd > 9) {
                charToAdd = convertToLetter(toAdd - 10);
            } else {
                charToAdd = (char) (toAdd + '0');
            }
            if (sb.indexOf(String.valueOf(charToAdd)) == -1) {
                sb.append(charToAdd);
            }
        }
        return sb.toString();
    }

    private char convertToLetter(int digit) {
        return (char)('a' + digit);
    }
    public void displayRange() {
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < this.size; i++) {
            System.out.print("*");
        }
        if (this.range > 10) {
            System.out.print(" (0-9, a-");
            System.out.print(convertToLetter(range - 11) +").");
        } else {
            System.out.print(" (0-" + (range - 1) + ").");
        }
    }
}
