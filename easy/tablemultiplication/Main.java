
public class Main{

	public static void resolve(int num) {
		for (int i = 1; i <= num; i++){
			for (int j = 1; j <= num; j++){
				System.out.printf("%4d", i*j);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		resolve(12);
	}
}
