import java.util.ArrayList;

/**
 * @author YuCheng
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	/**
	 *
	 * @param t Given a tree of integers a.
	 * @return a new tree containing all the elements of a with their sign negated.
	 */
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

	/**
	 *
	 * @param a Given a tree of integers a.
	 * @return a boolean value indicating whether all the values in its nods are even.
	 */
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

	/**
	 *
	 * @param a Given a tree of integers a.
	 * @param x The target value of the certain node is x.
	 * @return the depth of the given node value or -1 if it is not found.
	 */
	static int depth(Tree<Integer> a, int x) {
		try {
			return find(a, x, 0);
		} catch (IllegalArgumentException e) {
			return -1;
		}
	}

	/**
	 *
	 * @param a Given a tree of integers a.
	 * @param x The target value of the certain node is x.
	 * @param dep The current of the depth of the recursion.
	 * @return the depth of the given node value,or -1 if is not found.
	 */
	static int find(Tree<Integer> a, int x, int dep) {
		if (a.isEmpty()) return -1;
		if (a.value == x) {
			return dep;
		}
		return Math.max(find(a.left, x, dep + 1),
							find(a.right, x, dep + 1));


	}
	// Exercise 4

	/**
	 *
	 * @param a Given a tree a.
	 * @param <E> The generic type of the tree.
	 * @return a list containing the values in a  by traversing the nodes in preorder.
	 */
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

	/**
	 *
	 * @param a The binary search tree of integers a.
	 * @return a boolean value indicating whether a is a binary tree.
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty() || a.left.isEmpty() && a.right.isEmpty()) return true;
		if (!a.left.isEmpty() && a.value <= a.left.value) return false;
		if (!a.right.isEmpty() && a.value >= a.right.value) return false;
		return isSearchTree(a.left) && isSearchTree(a.right);
	}

	// Exercise 6
	/**
	 *
	 * @param a The binary search tree of integers a.
	 * @return print the values stored in it in descending order.
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty() ) {
			return;
		}
		printDescending(a.right);
		System.out.println(a.value);
		printDescending(a.left);
	}

	// Exercise 7
	/**
	 *
	 * @param a The binary search tree of integers a.
	 * @return The maximum value stored in the tree.
	 */
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

	/**
	 *
	 * @param a The binary search tree a.
	 * @param x The target value which is expected to be deleted.
	 * @return The resulting tree which the target value x from a.
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<>();
		}
		// delete from the right subtree
		if (x > a.value) {
			return new Tree<>(a.value, a.left, delete(a.right, x));
		}
		// delete from the left subtree
		else if (x < a.value) {
			return new Tree<>(a.value, delete(a.left, x), a.right);
		}
		// delete the current node
		else {
			// the node is leaf
			if (a.left.isEmpty() && a.right.isEmpty()) {
				return new Tree<>();
			}
			// the node is not a leaf and has a right subtree only
			else if (a.left.isEmpty()) {
				return a.right;
			}
			// the node is not a leaf and has a left subtree
			else {
				return new Tree<>(max(a.left), delete(a.left, max(a.left)), a.right);
			}
		}
	}

	// Exercise 9

	/**
	 *
	 * @param a The tree a.
	 * @param <E> The arbitrary element type E.
	 * @return a boolean value indicating whether a is the height-balanced tree.
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a == null || a.isEmpty() || a.left.isEmpty() && a.right.isEmpty()) {
			return true;
		}
		if (Math.abs(a.left.getHeight() - a.right.getHeight()) > 1) {
			return false;
		}
		return isHeightBalanced(a.left) && isHeightBalanced(a.right);
	}

	// Exercise 10

	/**
	 *
	 * @param a The height-balanced tree a.
	 * @param x The value x of the node are expected to inserted into the tree a.
	 * @return The height-balanced property of tree should be maintained after insert operation.
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		if (a == null || a.isEmpty()) {
			return new Tree<>(x, new Tree<>(), new Tree<>());
		}
		if (x < a.getValue()) {
			return balance( new Tree<>(a.value, insertHB(a.left, x), a.right) );
		} else  {
			return balance( new Tree<>(a.value, a.left, insertHB(a.right, x)));
		}

	}

	/**
	 *
	 * @param integerTree The tree has insert or delete the node.
	 * @return The balanced tree after inserting or deleting.
	 */
	private static Tree<Integer> balance(Tree<Integer> integerTree) {
		if (integerTree.isEmpty()) {
			return integerTree;
		}
		if (integerTree.left.getHeight() - integerTree.right.getHeight() > 1) {
			if (integerTree.left.left.getHeight() >= integerTree.left.right.getHeight()) {
				return leftleftRotation(integerTree);
			} else {
				return leftrightRotation(integerTree);
			}
		} else if (integerTree.right.getHeight() - integerTree.left.getHeight() > 1) {
			if (integerTree.right.right.getHeight() >= integerTree.right.left.getHeight()) {
				return rightrightRotation(integerTree);
			} else {
				return rightleftRotation(integerTree);
			}
		} else {
			return integerTree;
		}

	}
	/**
	 *
	 * @param t The unbalanced height of the tree.
	 * @return The height-balanced tree.
	 */
	private static Tree<Integer> rightleftRotation(Tree<Integer> t) {
		Tree<Integer> tr =  leftleftRotation(t.right);
		return rightrightRotation(new Tree<>(t.getValue(), t.left, tr));
	}

	/**
	 *
	 * @param t The unbalanced height of the tree.
	 * @return The height-balanced tree.
	 */
	private static Tree<Integer> leftrightRotation(Tree<Integer> t) {
		Tree<Integer> tl = rightrightRotation(t.left);
		return leftleftRotation(new Tree<>(t.getValue(), tl, t.right));
	}

	/**
	 *
	 * @param t The unbalanced height of the tree.
	 * @return The height-balanced tree.
	 */
	private static Tree<Integer> rightrightRotation(Tree<Integer> t) {
		return new Tree<>(t.right.getValue(),
				new Tree<>(t.getValue(), t.left, t.right.left),
				t.right.right);
	}

	/**
	 *
	 * @param t The unbalanced height of the tree.
	 * @return The height-balanced tree.
	 */
	private static Tree<Integer> leftleftRotation(Tree<Integer> t) {
		return new Tree<>(t.left.value,
				t.left.left,
				new Tree<>(t.getValue(), t.left.right, t.right));
	}
	/**
	 *
	 * @param a The height-balanced tree a.
	 * @param x The value x of the node are expected to deleted from the tree a.
	 * @return The height-balanced property of tree should be maintained after delete operation.
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if (a == null || a.isEmpty()) {
			return a;
		}
		// x is smaller than the current node
		if (x < a.getValue()) {
			return balance(new Tree<>(a.getValue(), deleteHB(a.left, x), a.right));
		}
		// x is larger than the current node
		else if (x > a.getValue()) {
			return balance(new Tree<>(a.getValue(), a.left,deleteHB(a.right, x)));
		}
		// x is equal to the value of the current node
		else {
			// a is the leaf node
			if (!a.left.isEmpty() && !a.right.isEmpty()) {
				return new Tree<>();
			}
			// a has the right node only
			else if (a.left.isEmpty()) {
				return a.right;
			}
			// a has the two subtree or left tree, then find the maximum node in the left tree
			else {
				return new Tree<>(max(a.left), deleteHB(a.left, max(a.left)), a.right);
			}
		}
	}

}

