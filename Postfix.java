/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Philip Jonsson
 * @version 2025-01-30
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        LinkedList<Integer> stack = new LinkedList<>();
        String temp = expr;
        String[] splitExpr = temp.split("\\s+");
        for (String s : splitExpr) {
            if (isInteger(s)) {
                stack.push(Integer.valueOf(s));
            }
            else if (isOperator(s)) {
                if (stack.size() < 2) {
                    throw new ExpressionException("Stack contains insufficient operands");
                }
                int operand2 = stack.pop();  // Pop the second operand
                int operand1 = stack.pop();  // Pop the first operand

                switch (s) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ExpressionException("Division by zero.");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new ExpressionException("Unknown operator: " + s);
                }       
            }
        }
        if (stack.size() != 1) {
            throw new ExpressionException("Invalid postfix expression.");
        }
        return stack.pop();
    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);  // Try parsing the string into an integer
            return true;  // If parsing works, it's a valid integer
        } catch (NumberFormatException e) {
            return false;  // If parsing fails, it's not a valid integer
        }
    }
}