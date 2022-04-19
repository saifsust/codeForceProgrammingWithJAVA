import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> a1 = Arrays.asList(1, 2, 3);
		List<Integer> a2 = Arrays.asList(4, 5, 6);
		List<Integer> a3 = Arrays.asList(7, 8, 9, 10, 11);

		List<List<Integer>> nums = new ArrayList<>();
		nums.add(a1);
		nums.add(a2);
		nums.add(a3);

		List<Integer> list = nums.stream().flatMap(items-> {
			for (Integer num : items) {
				System.out.printf("%d ", num);
			}
			System.out.println();
			return items.stream().filter(item-> item % 2 == 0).map(item -> item * 100);
		}).collect(Collectors.toList());

		System.out.println("===========");

		for (Integer num : list) {
			System.out.printf("%d ", num);
		}

		System.out.println();

	}

}

