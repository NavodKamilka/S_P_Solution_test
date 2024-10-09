import java.util.Arrays;
import java.util.Comparator;
public class Problem4 {
    public static String formLargestNumber(int[] nums) {
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        if (strNums[0].equals("0")) {
            return "0";
        }

        return String.join("", strNums);
    }

    public static void main(String[] args) {
        int[] nums = {50, 2, 1, 9};
        String largestNumber = formLargestNumber(nums);
        System.out.println("The largest number formed is: " + largestNumber);
    }
}
