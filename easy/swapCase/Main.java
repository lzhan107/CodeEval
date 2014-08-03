
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 64 && s.charAt(i) < 91) {
				sb.append((s.charAt(i) + "").toLowerCase());
			} else if (s.charAt(i) > 96 && s.charAt(i) < 123) {
				sb.append((s.charAt(i) + "").toUpperCase());
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
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
