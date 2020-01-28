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

	/**
	 *
	 * @param m The base of the power function.
	 * @param n The exponent of the function that is how many times should be multiplied by the base.
	 * @return The result of the power function.
	 */
	 static int power(int m, int n) {
	 	if (n <= 0) return 1;
		return m * power(m, n - 1); // replace this by your code
	}

	/**
	 *
	 * @param m The base of the power function.
	 * @param n The exponent of the function that is how many times should be multiplied by the base.
	 * @return The result of the fastpower function.
	 */
	 static int fastPower(int m, int n) {
		if (n == 0) return 1;
		if (n == 1) return m;
		if (n % 2 == 0)
			return fastPower(m * m, n / 2);
		else
	 	return fastPower(m * m, n / 2) * m; // replace this by your code
	}

	// Exercise 2

	/**
	 *
	 * @param a The list contains the value of type of integer.
	 * @return The negate value of the original node in the List.
	 */
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

	/**
	 *
	 * @param x The target number which is to search for.
	 * @param a The given the list.
	 * @return The index of the target number in the list or IllegalArgumentException if is not found.
	 */
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

	/**
	 *
	 * @param a The given list.
	 * @return whether the value of node is even in the list.
	 */
	 static boolean allEven(List<Integer> a) {
		if (a.isEmpty())
			return true;
		return a.getHead() % 2 == 0 && allEven(a.getTail()); // replace this by your code
	}

	// Exercise 5

	/**
	 *
	 * @param a Given a list of integer.
	 * @return a new list which contains all the even element in the given list.
	 */
	 static List<Integer> evenNumbers(List<Integer> a) {
		if (a.isEmpty())
			return a;

		return a.getHead() % 2 == 0 ?
				new List<Integer>(a.getHead(), evenNumbers(a.getTail())):
				evenNumbers(a.getTail()); // replace this by your code
	}

	// Exercise 6

	/**
	 *
	 * @param a Given a list of integers.
	 * @return a boolean value indicating whether a is sorted in
	 * descending order.
	 */
	 static boolean sorted(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) return true;
		return a.getHead() >= a.getTail().getHead() && sorted(a.getTail()); // replace this by your code
	}

	// Exercise 7

	/**
	 *
	 * @param a Given a list of integer.
	 * @param b Given a list of integer.
	 * @return The list of integer which element arranged in a descending order.
	 */
	 static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) return b;
		if (b.isEmpty()) return a;
		return a.getHead()>= b.getHead()?
				new List<Integer>(a.getHead(), merge(a.getTail(), b)):
				new List<>(b.getHead(), merge(a,b.getTail())); // replace this by your code
	}

	// Exercise 8

	/**
	 *
	 * @param a Given a list of integers.
	 * @return The list of integers which remove the duplicate element from the given list.
	 */
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
