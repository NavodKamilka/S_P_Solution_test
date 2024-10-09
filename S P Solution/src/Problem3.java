import java.util.ArrayList;
import java.util.List;
public class Problem3 {

    public static List<Long> generateFibonacci(int count) {
        List<Long> fibonacciSequence = new ArrayList<>();

        if (count >= 1) {
            fibonacciSequence.add(0L);
        }
        if (count >= 2) {
            fibonacciSequence.add(1L);
        }

        for (int i = 2; i < count; i++) {
            long nextFib = fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2);
            fibonacciSequence.add(nextFib);
        }

        return fibonacciSequence;
    }
    public static void main(String[] args)
    {
        List<Long> fibonacciSequence = generateFibonacci(100);
        System.out.println("First 100 Fibonacci numbers: " + fibonacciSequence);
    }
}
