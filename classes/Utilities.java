package expression.classes;

class Utilities {
    static int log(int first, int second) {
        int result = 0;
        while (second >= first) {
            second /= first;
            result++;
        }
        return result;
    }

    static int pow(int first, int second) throws OverflowException {
        int result = 1;
        while (second != 0) {
            if (second % 2 == 1) {
                multiplyOverflowChecker(result, first);
                result *= first;
            }
            second /= 2;
            if (second != 0) {
                multiplyOverflowChecker(first, first);
                first *= first;
            }
        }
        return result;
    }

    static void multiplyOverflowChecker(int first, int second) throws OverflowException {
        if (first != 0 && second != 0) {
            int result = first * second;
            if (result / first != second || result / second != first) {
                throw new OverflowException(null);
            }
        }
    }
}
