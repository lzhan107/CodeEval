
public class Main {

	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static long resolve() {
		long sum = 0;
		int i = 0;
		int j = 2;
		while (i < 1000) {
			if (isPrime(j)) {
				sum += j;
				i++;
			}
			j++;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(resolve());
	}
}
