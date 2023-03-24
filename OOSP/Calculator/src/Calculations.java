import static java.lang.Math.pow;

public class Calculations {
    private String[] index;
    private int pointer;

    public void calculate(String uravn) {
        this.index = uravn.split(" ");
        this.pointer = 0;
    }

    public double calculate(){
        double first = miltiply();

        while (pointer < index.length) {
            String operator = index[pointer];
            if (!operator.equals("+") && !operator.equals("-")){
                break;
            } else {
                pointer++;
            }

            double second = miltiply();
            if (operator.equals("+")) {
                first += second;
            }
            else {
                first -= second;
            }
        }
        return first;
    }

    private double miltiply() {
        double first = this.priorities();

        while(this.pointer < this.index.length) {
            String operator = this.index[this.pointer];
            if (!operator.equals("*") && !operator.equals("/") && !operator.contains("%") &&
                    !operator.equals("^") && !operator.equals("//")) {
                break;
            }

            ++this.pointer;
            double second = this.priorities();

            if (operator.equals("*")) {
                first *= second;
            }
            else if (operator.equals("/")) {
                first /= second;
            }
            else if (operator.equals("%")){
                first %= second;
            }
            else if (operator.equals("^")) {
                if (second == 1) {
                    return first;
                }
                else {
                    return first * pow(first,second - 1);
                }
            }
            else if (operator.equals("//")){
                if (first>0 && second>0) {
                    first = Math.floor(first/second);
                    return first;
                }
                if (first<0 && second<0){
                    first = Math.floor(first/second);
                    return first;
                }
                if (first>0 && second<0) {
                    first = Math.ceil(first/second);
                    return first;
                }
                if (first<0 && second>0){
                    first = Math.ceil(first/second);
                    return first;
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
            } else new IllegalArgumentException("ожидали ']' но появился символ " + closBracket + "");
        }

        pointer++;
        return Double.parseDouble(next);
    }

}

Все плохо передалай
