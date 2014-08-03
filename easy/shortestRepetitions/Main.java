
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int resolve(String s) {
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			int len = sub.length();
			for (int j = i + 1; j < s.length(); j = j + len) {
				if (len > s.length() / 2)
					return s.length();
				if (!sub.equals(s.substring(j, j + len)))
					break;
				if (j == s.length() - len)
					return len;
			}
		}
		return s.length();
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
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
