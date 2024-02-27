package org.globant.day1;

/**
 * Title: Alphanumeric String Sort
 * Description:
 * Taking a string as input sort the string characters with the following rules:
 *  - Numbers go after Letters
 *  - Uppercase letters go after Lowercase
 *  - Odd numbers go before Even numbers
 *  - Any character that is not a letter or number should go after the letters and numbers
 */
public class AlphaNumericStringSort {

    private final int MIN_ALPHA_NUMERIC_VALUE = 0;
    private String input;

    public AlphaNumericStringSort(String input) {
        this.input = input;
    }

    public String solve() {
        StringBuilder evenNumbers = new StringBuilder();
        StringBuilder oddNumbers = new StringBuilder();
        StringBuilder lowerCase = new StringBuilder();
        StringBuilder upperCase = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();

        for (char currentChar : this.input.toCharArray()) {
            if(isSpecialCharacter(currentChar)) {
                specialCharacters.append(currentChar);
            } else if(Character.isDigit(currentChar)) {
                processNumbers(oddNumbers,evenNumbers,currentChar);
            } else if(Character.isUpperCase(currentChar)) {
                upperCase.append(currentChar);
            } else if(Character.isLowerCase(currentChar)) {
                lowerCase.append(currentChar);
            } else {
                specialCharacters.append(currentChar);
            }
        }

        return lowerCase
                .append(upperCase)
                .append(oddNumbers)
                .append(evenNumbers)
                .append(specialCharacters)
                .toString();
    }

    private void processNumbers(StringBuilder oddNumbers, StringBuilder evenNumbers, char c) {
        int number = Character.getNumericValue(c);
        if (number % 2 == 0) {
            evenNumbers.append(c);
        } else {
            oddNumbers.append(c);
        }
    }

    private boolean isSpecialCharacter(char c) {
        return Character.getNumericValue(c) < MIN_ALPHA_NUMERIC_VALUE;
    }
}