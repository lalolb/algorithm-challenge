package org.globant.day2;

/**
 * Challenge name: balanced-parentheses
 * Description:
 * Given a string that may contain parentheses validate if it has all being and ending parentheses
 * Examples:
 *  input:   ()
 *  output: valid
 *  input:   (hello, world)
 *  output: valid
 *  input:   Random text (as this) is ok().
 *  output: valid
 *  input:   )(
 *  output: invalid
 *  input:   (Hello (,) world (!))
 *  output: valid
 *  input:   )()(
 *  output: invalid
 *  input:   ())(()
 *  output: invalid
 */
public class BalancedParentheses {

    private String input;

    public BalancedParentheses(String input) {
        this.input = input;
    }

    public boolean solve() {
        int parenthesesCount = 0;
        for (char currentChar : this.input.toCharArray()) {
            if(currentChar == '(') {
                parenthesesCount++;
            } else if(currentChar == ')') {
                if (parenthesesCount <= 0) return false;
                parenthesesCount--;
            }
        }

        return parenthesesCount == 0;
    }
}
