
public class Main {

	public static void resolve() {
		int i = 1;
		while (i < 100) {
			if (i % 2 != 0)
				System.out.println(i);
			i++;
		}
	}

	public static void main(String[] args) {
		resolve();
	}
}