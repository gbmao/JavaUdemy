public class Calculator {

    public int integerDivision(int dividend, int divisor) {
        return dividend/divisor;
    }

    public int integerSubtraction(int number, int subtrahend) {
        return number - subtrahend;
    }

    public double squareRoot(double number) {
        if(number <= 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
}
