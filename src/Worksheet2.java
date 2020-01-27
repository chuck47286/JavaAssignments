import java.util.ArrayList;

/**
 * @author YuCheng
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()) {
			return new Tree<>();
		}
		Tree<Integer> tleft = new Tree<>();
		Tree<Integer> tright = new Tree<>();
		if (!t.left.isEmpty()) {
			tleft = negateAll(t.left);
		}
		if (!t.right.isEmpty()) {
			tright = negateAll(t.right);
		}
		return new Tree<>(-t.value, tleft, tright);
	}

	// Exercise 2

	static boolean allEven(Tree<Integer> a) {
		if (a.isEmpty()) {
			return true;
		}
		return a.value % 2 == 0 && allEven(a.left) && allEven(a.right);
		/*boolean al = false;
		boolean ar = false;
		if (!a.left.isEmpty()) {
			al = allEven(a.left);
		}
		if (!a.right.isEmpty()) {
			ar = allEven(a.right);
		}
		return a.value % 2 == 0 && al && ar;*/
	}

	// Exercise 3
	static int depth(Tree<Integer> a, int x) {
		try {
			return find(a, x, 0);
		} catch (IllegalArgumentException e) {
			return -1;
		}
	}
	static int find(Tree<Integer> a, int x, int dep) {
		if (a.isEmpty()) return -1;
		if (a.value == x) {
			return dep;
		}
		return Math.max(find(a.left, x, dep + 1),
		find(a.right, x, dep + 1));


	}
	// Exercise 4
	static <E> List<E> preorder(Tree<E> a) {
		if (a.isEmpty()) {
			return new List<>();
		}
		List<E> ar = new List<>();
		List<E> al = new List<>();
		if (!a.right.isEmpty()) {
			 ar = preorder(a.right);
		}
		if (!a.left.isEmpty()) {
			 al = preorder(a.left);
		}
//		List<E> lr = merge(al, ar);
//		List<E> res = new List(a.value, lr);
		return new List<>(a.value, merge(al, ar));
	}

	/**
	 *
	 * @param al The list from the left subtree.
	 * @param ar The list from the right subtree.
	 * @param <E> The generic type of the List.
	 * @return The merge list of two list from subtrees.
	 */
	private static <E> List<E> merge(List<E> al, List<E> ar) {
		if (al.isEmpty()) return ar;
		return new List<>(al.getHead(), merge(al.getTail(), ar));
	}


	// Exercise 5

	static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty() || a.left.isEmpty() && a.right.isEmpty()) return true;
		if (!a.left.isEmpty() && a.value <= a.left.value) return false;
		if (!a.right.isEmpty() && a.value >= a.right.value) return false;
		return isSearchTree(a.left) && isSearchTree(a.right);
	}

	// Exercise 6

	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty() ) {
			return;
		}
		printDescending(a.right);
		System.out.println(a.value);
		printDescending(a.left);
	}

	// Exercise 7

	static int max(Tree<Integer> a) {
		if (a == null || a.isEmpty()) return 0;
		if (a.right.isEmpty()) {
			return a.value;
		}
//		if (a.right.isEmpty())
//			return a.value;
		return max(a.right);
	}

	// Exercise 8

	static Tree<Integer> delete(Tree<Integer> a, int x) {

		return new Tree<Integer>();
	}

	// Exercise 9
	static <E> boolean isHeightBalanced(Tree<E> a) {
		return true;
	}

	// Exercise 10

	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		return new Tree<Integer>();
	}

	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		return new Tree<Integer>();
	}

}

