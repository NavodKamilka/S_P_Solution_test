
public class Problem1 {

    public static int sumUsingForLoop(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int sumUsingWhileLoop(int[] numbers) {
        int sum = 0;
        int i = 0;
        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }
        return sum;
    }

    public static int sumUsingRecursion(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        } else {
            return numbers[index] + sumUsingRecursion(numbers, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Sum using for-loop: " + sumUsingForLoop(numbers));
        System.out.println("Sum using while-loop: " + sumUsingWhileLoop(numbers));
        System.out.println("Sum using recursion: " + sumUsingRecursion(numbers, 0));
    }
}
