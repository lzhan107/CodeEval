
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int resolve(String s) {
		String[] ss = s.split(",");
		int N = Integer.valueOf(ss[0]);
		int M = Integer.valueOf(ss[1]);

		if (N < M)
			return N;

		int i = 1;
		int original = M;
		while (i > 0) {
			M = i * original;
			if (++i * original > N)
				break;
		}
		return N - M;
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0)
				System.out.println(resolve(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
