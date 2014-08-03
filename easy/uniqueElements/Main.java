
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String data) {
		/**
		 * Only working for single digit elements
		 */
		/*
		 * data = data + "@@"; StringBuilder sb = new StringBuilder(); for (int
		 * i = 0; i < data.length() - 2; i = i + 2){ if (data.charAt(i) ==
		 * data.charAt(i + 2)) continue; sb.append(data.charAt(i)); if (i !=
		 * data.length() - 3) sb.append(","); } System.out.println(sb);
		 */
		String[] s = (data + ",@").split(",");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length - 1; i++) {
			if (s[i].equals(s[i + 1]))
				continue;
			sb.append(s[i]);
			if (i != s.length - 2)
				sb.append(",");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				resolve(line);
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
