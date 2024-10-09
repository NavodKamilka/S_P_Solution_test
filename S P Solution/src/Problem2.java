import java.util.*;
public class Problem2 {

    public static List<Object> combineAlternating(List<Object> list1, List<Object> list2) {
        List<Object> combinedList = new ArrayList<>();
        int size = Math.min(list1.size(), list2.size());

        for (int i = 0; i < size; i++) {
            combinedList.add(list1.get(i));
            combinedList.add(list2.get(i));
        }

        if (list1.size() > list2.size()) {
            combinedList.addAll(list1.subList(size, list1.size()));
        } else if (list2.size() > list1.size()) {
            combinedList.addAll(list2.subList(size, list2.size()));
        }

        return combinedList;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first list of elements : ");
        String[] input1 = scanner.nextLine().split(" ");  // 1 2 3 likewise input should enter (with spaces)
        List<Object> list1 = new ArrayList<>();
        for (String element : input1) {
            list1.add(element);
        }

        System.out.println("Enter the second list of elements : ");
        String[] input2 = scanner.nextLine().split(" ");
        List<Object> list2 = new ArrayList<>();
        for (String element : input2) {
            list2.add(element);
        }

        List<Object> combinedList = combineAlternating(list1, list2);

        System.out.println("Combined list: " + combinedList);
    }
}
