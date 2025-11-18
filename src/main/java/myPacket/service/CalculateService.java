package myPacket.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    /**
     * <p>Performs num1 mathematical operation on user input data and return String representation of this result.</p>
     *
     * <p>Examples:
     * <blockquote><pre>
     * calculate("+", 2, 2) -> 4
     * calculate("*", 2, 3) -> 6
     * calculate("", 2, 2) -> "error"
     * calculate("*", 9999999, 999999) -> "error"
     * </pre></blockquote>
     * @param sym symbol of mathematical operation {@code *},{@code /},{@code +},{@code -}
     * @param num1 first user input number
     * @param num2 second user input number
     * @return {@code String} result of mathematical operation if incoming data is correct, and
     * String {@code "error"} if result out of bounds int or sym is not equal to {@code *},{@code /},{@code +},{@code -}
     * @throws NullPointerException if {@code sym} is null
     * @see #checkIntOutOfBounds(int, int, String)
     */
    public String calculate(String sym, int num1, int num2) {
        if (checkIntOutOfBounds(num1, num2, sym)) {
            return switch (sym) {
                case "-" -> Integer.toString(num1 - num2);
                case "+" -> Integer.toString(num1 + num2);
                case "/" -> Integer.toString(num1 / num2);
                case "*" -> Integer.toString(num1 * num2);
                default -> "error";
            };
        }
        return "error";
    }


    /**
     * <p>Checks that the result of the calculation does not exceed the int limit and return true - if
     * input data is correct, or false - if uncorrected.</p>
     * <p>Examples:
     * <blockquote><pre>
     * filter(345, 234, "+") -> true
     * calculate("*", 9999999, 9999999) -> false
     * </pre></blockquote>
     * @param num1 first user input number.
     * @param num2 second user input number.
     * @param sym symbol of mathematical operation {@code *},{@code /},{@code +},{@code -}.
     * @return {@code true} if request is correct (result of calculations can't be out of bounds int), and
     * {@code false} if request is uncorrected.
     * @throws NullPointerException if {@code sym} is null.
     */
    public boolean checkIntOutOfBounds(int num1, int num2, String sym) {
        return sym.equals("*") && (num1 >= 0 && num2 >= 0) && Integer.MAX_VALUE / num2 >= num1 ||
                sym.equals("*") && (num1 <= 0 && num2 >= 0) && Integer.MIN_VALUE / num2 <= num1 ||
                sym.equals("*") && (num1 >= 0 && num2 <= 0) && Integer.MIN_VALUE / num2 >= num1 ||
                sym.equals("*") && (num1 <= 0 && num2 <= 0) && (num1 != Integer.MIN_VALUE &&
                        num2 != Integer.MIN_VALUE) && Integer.MIN_VALUE / num2 >= Math.abs(num1) ||
                sym.equals("+") && (num1 >= 0 && num2 >= 0) && Integer.MAX_VALUE - num2 >= num1 ||
                sym.equals("+") && (num1 <= 0 && num2 >= 0) && Integer.MAX_VALUE > num2 ||
                sym.equals("+") && (num1 <= 0 && num2 <= 0) && Integer.MAX_VALUE - Math.abs(num2) >= Math.abs(num1) ||
                sym.equals("+") && (num1 >= 0 && num2 <= 0) && Integer.MAX_VALUE > num1 ||
                sym.equals("-") && (num1 <= 0 && num2 >= 0) && Integer.MIN_VALUE + num2 <= num1 ||
                sym.equals("-") && (num1 >= 0 && num2 <= 0) && Integer.MAX_VALUE - num1 > Math.abs(num2) ||
                sym.equals("-") && (num1 >= 0 && num2 >= 0) ||
                sym.equals("-") && (num1 <= 0 && num2 <= 0) || sym.equals("/");
    }
}