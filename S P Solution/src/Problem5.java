import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {

    public static int evaluateExpression(String expression) {
        return (int) new Object() {
            int index = -1, charAt;
            void nextChar() {
                charAt = (++index < expression.length()) ? expression.charAt(index) : -1;
            }
            boolean eat(int charToEat) {
                while (charAt == ' ') nextChar();
                if (charAt == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            int parse() {
                nextChar();
                int value = parseExpression();
                if (index < expression.length()) throw new RuntimeException("Unexpected: " + (char)charAt);
                return value;
            }
            int parseExpression() {
                int value = parseTerm();
                while (true) {
                    if (eat('+')) value += parseTerm();
                    else if (eat('-')) value -= parseTerm();
                    else return value;
                }
            }
            int parseTerm() {
                int value;
                int startIndex = this.index;
                if (eat('(')) {
                    value = parseExpression();
                    eat(')');
                } else if ((charAt >= '0' && charAt <= '9')) {
                    while (charAt >= '0' && charAt <= '9') nextChar();
                    value = Integer.parseInt(expression.substring(startIndex, this.index));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)charAt);
                }
                return value;
            }
        }.parse();
    }

    public static void findCombinations(List<String> results, String digits, String expression, int index, int target) {
        if (index == digits.length()) {
            if (evaluateExpression(expression) == target) {
                results.add(expression);
            }
            return;
        }

        findCombinations(results, digits, expression + digits.charAt(index), index + 1, target);

        findCombinations(results, digits, expression + "+" + digits.charAt(index), index + 1, target);

        findCombinations(results, digits, expression + "-" + digits.charAt(index), index + 1, target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the array of digits ");   //input should 123456789 then enter
        String digits = scanner.nextLine();

        //System.out.println("digit " +digits);

        int target = 100;

        List<String> results = new ArrayList<>();

        findCombinations(results, digits, "" + digits.charAt(0), 1, target);

        System.out.println("All expressions that result in " + target + ":");
        for (String result : results) {
            System.out.println(result);
        }
    }
}
