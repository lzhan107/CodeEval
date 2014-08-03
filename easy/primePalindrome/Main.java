
import java.util.Stack;

public class Main {

	public static boolean isPalindrome(int num) {
		String strVal = String.valueOf(num);
		Stack<Character> stack = new Stack<>();
		StringBuilder revStrVal = new StringBuilder();
		for (int i = 0; i < strVal.length(); i++) {
			stack.push(strVal.charAt(i));
		}

		while (!stack.isEmpty()) {
			revStrVal.append(stack.pop());
		}

		return strVal.equals(revStrVal.toString());
	}

	public static boolean isPrime(int num) {
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i < num; i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static int resolve() {
		int num = 0;
		for (int i = 1000; i >= 0; i--) {
			if (isPalindrome(i) && isPrime(i)) {
				num = i;
				break;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(resolve());
	}
}
