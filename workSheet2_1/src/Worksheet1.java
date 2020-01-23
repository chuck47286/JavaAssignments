/**
 * @author YuCheng This class contains the solution for Worksheet1.
 */

 public class Worksheet1 {
	// print list
	static void printList(List<Integer> L) {
		if (L.isEmpty()) {
			return;
		} else {
			System.out.println(L.getHead());
			printList(L.getTail());
		}
	}
	// Exercise 1

	 static int power(int m, int n) {
	 	if (n <= 0) return 1;
		return m * power(m, n - 1); // replace this by your code
	}

	 static int fastPower(int m, int n) {
		if (n == 0) return 1;
		if (n == 1) return m;
		if (n % 2 == 0)
			return fastPower(m * m, n / 2);
		else
	 	return fastPower(m * m, n / 2) * m; // replace this by your code
	}

	// Exercise 2

	 static List<Integer> negateAll(List<Integer> a) {
//		List<Integer> res = new List<>();
//		Integer aHead = a.getHead();
		if (a.isEmpty()) {
			return a;
		} else {
			return new List<>(a.getHead() * (-1), negateAll(a.getTail()));
		}
//		return res; // replace this by your code
	}

	// Exercise 3
	 static int find(int x, List<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("cannot find");
		} else {
			if (x != a.getHead()) {
				return find(x, a.getTail()) + 1;
			} else
			return 0;
		}
	}

	// Exercise 4

	 static boolean allEven(List<Integer> a) {
		if (a.isEmpty())
			return true;
		return a.getHead() % 2 == 0 && allEven(a.getTail()); // replace this by your code
	}

	// Exercise 5

	 static List<Integer> evenNumbers(List<Integer> a) {
		if (a.isEmpty())
			return a;

		return a.getHead() % 2 == 0 ?
				new List<Integer>(a.getHead(), evenNumbers(a.getTail())):
				evenNumbers(a.getTail()); // replace this by your code
	}

	// Exercise 6

	 static boolean sorted(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) return true;
		return a.getHead() >= a.getTail().getHead() && sorted(a.getTail()); // replace this by your code
	}

	// Exercise 7

	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) return b;
		if (b.isEmpty()) return a;
		return a.getHead()>= b.getHead()?
				new List<Integer>(a.getHead(), merge(a.getTail(), b)):
				new List<>(b.getHead(), merge(a,b.getTail())); // replace this by your code
	}

	// Exercise 8

	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) return a;
		List<Integer> lista = isNotDuplicate(a);
		return new List<Integer>(lista.getHead(), removeDuplicates(lista.getTail())); // replace this by your code
	}

	private static List<Integer> isNotDuplicate(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) return a;
		if (a.getHead() == a.getTail().getHead()) {
			return isNotDuplicate(a.getTail());
		} else
			return a;
	}

}
