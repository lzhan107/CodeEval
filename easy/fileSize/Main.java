
import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File(args[0]);
		if (!file.exists())
			System.out.println(-1);
		else
			System.out.println(file.length());
	}
}
