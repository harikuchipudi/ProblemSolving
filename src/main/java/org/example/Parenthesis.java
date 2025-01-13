package org.example;
import java.util.ArrayList;
import java.util.List;

class Parenthesis {
    public static List<Integer> diffWaysToCompute(String expression) {
        // Base case: if the expression is a single number, return it as a result.
        if (isNumber(expression)) {
            List<Integer> baseResult = new ArrayList<>();
            baseResult.add(Integer.parseInt(expression));
            return baseResult;
        }

        List<Integer> results = new ArrayList<>();

        // Loop through the expression to find operators
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Check if the current character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Divide: compute results for left and right sub-expressions
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

                // Conquer: combine results from left and right using the operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        results.add(calculate(left, right, c));
                    }
                }
            }
        }

        return results;
    }

    // Helper function to check if the expression is a single number
    private static boolean isNumber(String expression) {
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // Helper function to compute the result of a single operation
    private static int calculate(int left, int right, char operator) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {

        // Test cases
        String expression1 = "2-1-1";
        String expression2 = "2*3-4*5";

        System.out.println(diffWaysToCompute(expression1)); // Output: [0, 2]
        System.out.println(diffWaysToCompute(expression2)); // Output: [-34, -14, -10, -10, 10]
    }
}
