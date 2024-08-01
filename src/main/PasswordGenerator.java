package main;

import java.util.Random;

public class PasswordGenerator {
    private final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private final String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private  final String numbers = "0123456789";
    private final String specialCharacters = "<>,.?{}[]/+-*()&^%$#@!+~_";
    private final String combination = lowerCaseLetters + upperCaseLetters + numbers + specialCharacters;
    private final int length = 8;
    char[] password = new char[length];
    Random random = new Random();
    public  void passwordGenerator() {
        for (int i = 0; i < password.length; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        System.out.println("Random Generated Password is: " + new String(password));
    }
}
