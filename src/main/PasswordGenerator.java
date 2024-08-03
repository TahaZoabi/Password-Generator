package main;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String NUMBERS = "0123456789";
    private final String SPECIAL_CHARACTERS = "<>,.?{}[]/+-*()&^%$#@!+~_";

    private int length;
    private boolean includeUpperCase;
    private boolean includeLowerCase;
    private boolean includeNumbers;
    private boolean includeSpecialCharacters;

    public void generate() {
        System.out.println("Welcome to the Password Generator");
        length = getPositiveInteger("Enter the length of the password: ");

        includeUpperCase = getBooleanInput("Would you like to include upper case letters? (Y/N): ");
        includeLowerCase = getBooleanInput("Would you like to include lower case letters? (Y/N): ");
        includeNumbers = getBooleanInput("Would you like to include numbers? (Y/N): ");
        includeSpecialCharacters = getBooleanInput("Would you like to include special characters? (Y/N): ");

        String combination = buildCombination();

        if (combination.isEmpty()) {
            System.out.println("No valid characters available for password generation.");
            return;
        }

        String generatedPassword = generatePassword(combination);
        System.out.println("Random Generated Password is: " + generatedPassword);
    }

    public String buildCombination() {
        StringBuilder combination = new StringBuilder();
        if (includeUpperCase) combination.append(UPPER_CASE_LETTERS);
        if (includeLowerCase) combination.append(LOWER_CASE_LETTERS);
        if (includeNumbers) combination.append(NUMBERS);
        if (includeSpecialCharacters) combination.append(SPECIAL_CHARACTERS);
        return combination.toString();
    }

    public String generatePassword(String combination) {
        char[] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        return new String(password);
    }

    public boolean getBooleanInput(String prompt) {
        String input;
        System.out.print(prompt);
        input = scanner.next().trim().toLowerCase();
        while (!input.equals("y") && !input.equals("n")) {
            System.out.print(prompt);
            input = scanner.next().trim().toLowerCase();
        }
        return input.equals("y");
    }


    public int getPositiveInteger(String prompt) {
        int value;
            System.out.print(prompt);
            value = scanner.nextInt();
            while (value <= 0) {
                System.out.println("The length must be a positive integer.");
                value = scanner.nextInt();
            }
            scanner.nextLine();
            return value;
        }
    }


