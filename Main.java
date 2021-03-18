package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int codeSize = 0;
        int range = 0;

        System.out.println("Please, enter the secret code's length:");
        try {
            codeSize = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: " + codeSize + " isn't a valid number");
        }

        System.out.println("Input the number of possible symbols in the code: ");
        try {
            range = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: " + range + " isn't a valid number");
        }

        if (range > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else if (codeSize > range || codeSize < 1) {
            System.out.println("Error: it's not possible to generate a code with a length more than the number of unique symbols or less than 1.");
        } else {
            CodeMaker codeMaker = new CodeMaker(codeSize, range);
            codeMaker.displayRange();
            System.out.println("Okay, let's start a game!");
            playGame(codeMaker.createCode());
        }
    }


    public static void printResults(int bulls, int cows) {
        if (bulls > 0 && cows > 0) {
            System.out.print("Grade: " + bulls + " bull(s)" + cows + " cow(s).");
            return;
        }
        if (bulls > 0) {
            System.out.print("Grade: " + bulls + " bull(s).");
            return;
        }
        if (cows > 0) {
            System.out.print("Grade: " + cows + " cow(s).");
            return;
        }
        System.out.print("Grade: None.");
    }

    public static void playGame(String passcode) {
        int bulls = 0;
        int turns = 0;

        System.out.println(passcode);

        while (bulls < passcode.length()) {
            int cows = 0;
            bulls = 0;
            turns++;
            System.out.println("Turn: " + turns);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] codeParts = passcode.split("");
            String[] inputParts = input.split("");


            for (int codeI = 0; codeI < codeParts.length; codeI++) {
                for (int inputI = 0; inputI < inputParts.length; inputI++) {
                    if (codeParts[codeI].equals(inputParts[inputI])) {
                        if (codeI == inputI) {
                            bulls++;
                        } else {
                            cows++;
                        }
                    }
                }
            }
            printResults(bulls, cows);
            System.out.println();
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }


}




