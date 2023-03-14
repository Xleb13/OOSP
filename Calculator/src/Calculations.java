import static java.lang.Math.floorDiv;
import static java.lang.Math.pow;

public class Calculations {
    private String[] index;
    private int pointer;

    public void decoding(String uravn) {
        this.index = uravn.split(" ");
        this.pointer = 0;
    }

    public double calculate() {
        double first = miltiply();

        while (pointer < index.length) {
            String operator = index[pointer];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pointer++;
            }

            double second = miltiply();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private double miltiply() {
        double first = priorities();

        while (pointer < index.length) {
            String operator = index[pointer];
            if (!operator.equals("*") && !operator.equals("/") && !operator.equals("^") && !operator.equals("%") && !operator.equals("//")) {
                break;
            } else {
                pointer++;
            }

            double second = priorities();
            if (operator.equals("*")) {
                first *= second;
            } else if (operator.equals("/")) {
                first /= second;
            } else if (operator.equals("%")) {
                first %= second;
            } else if (operator.equals("//")) {
                first = Math.floor(first / second);
            } else {
                if (second == 1) {
                    return first;
                } else {
                    return first * pow(first, second - 1);
                }
            }

        }
        return first;
    }


    private double priorities() {
        String next = index[pointer];
        double result;
        if (next.equals("(")) {
            pointer++;
            result = calculate();
            String closBracket;
            if (pointer < index.length) {
                closBracket = index[pointer];
            } else {
                throw new IllegalArgumentException("Не найдено ')'");
            }
            if (closBracket.equals(")")) {
                pointer++;
                return result;
            } else new IllegalArgumentException("ожидали ')' но появился символ " + closBracket + "");
        }

        if (next.equals("[")) {
            pointer++;
            result = calculate();
            String closBracket;
            if (pointer < index.length) {
                closBracket = index[pointer];
            } else {
                throw new IllegalArgumentException("Не найдено ']'");
            }
            if (closBracket.equals("]")) {
                pointer++;
                return Math.abs(result);
            } else new IllegalArgumentException("ожидали ')' но появился символ " + closBracket + "");
        }

        pointer++;
        return Double.parseDouble(next);
    }

}