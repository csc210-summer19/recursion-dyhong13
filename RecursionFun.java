/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Dylan Y Hong
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n >= k && k >= 1) {
			if (k == 1 || n == k) {
				return n / k;
			} else {
				return combinations(n - 1, k - 1) + combinations(n - 1, k);
			}
		}
		return 0;
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String num = String.valueOf(n);
		if (n / 1000 >= 1) {
			return intWithCommas(n / 1000) + ","
					+ num.substring(num.length() - 3);
		} else {
			return num;
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		int temp = x[index];
		x[index] = x[len - index - 1];
		x[len - index - 1] = temp;
		if (index < len / 2 - 1) {
			reverseArray(x, index + 1, len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRange(a, 0, a.length); // Helper function.
	}

	// No requirement to keep the array the same...
	private int arrayRange(int[] a, int index, int len) {
		if (index == len - 1) {
			return a[len - 1] - a[0];
		} else {
			int temp = a[index];
			if (a[index] > a[len - 1]) {
				a[index] = a[len - 1];
				a[len - 1] = temp;
			} else if (a[index] < a[0]) {
				a[index] = a[0];
				a[0] = temp;
			}
			return arrayRange(a, index + 1, len);
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return isSorted(nums, 0, nums.length); // Helper function.
	}

	public boolean isSorted(int[] nums, int index, int len) {
		if (index >= len - 1) {
			return true;
		} else if (nums[index] > nums[index + 1]) {
			return false;
		} else {
			return isSorted(nums, index + 1, len);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0, strs.length); // Helper function.
	}

	private boolean found(String search, String[] strs, int index, int len) {
		if (strs[index].equals(search)) {
			return true;
		} else if (index == len - 1) {
			return false;
		} else {
			return found(search, strs, index + 1, len);
		}
	}
}
