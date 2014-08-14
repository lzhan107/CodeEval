
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isAlphabetic(s.charAt(i))) {
				sb.append(s.charAt(i));
				continue;
			}
			sb.append((s.charAt(i) + "").toUpperCase());
			for (int j = i + 1; j < s.length(); j++) {
				if (!Character.isAlphabetic(s.charAt(j))) {
					if (j != s.length() - 1)
						sb.append(s.charAt(j));
					continue;
				} else {
					sb.append(s.charAt(j));
					i = j;
					break;
				}
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
