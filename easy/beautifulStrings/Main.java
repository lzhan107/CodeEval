
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int findMax(StringBuilder s) {
		int maxCount = 1;
		int count = 1;
		int idx = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if ((s.charAt(i) + "").toLowerCase().equals(
					(s.charAt(i + 1) + "").toLowerCase()))
				count++;
			else
				count = 1;
			if (maxCount < count) {
				maxCount = count;
				idx = i + 1;
			}
		}
		s.replace(idx - maxCount + 1, idx + 1, "");
		return maxCount;
	}

	public static void resolve(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i))) {
				if (sb.toString().toLowerCase()
						.contains((s.charAt(i) + "").toLowerCase())) {
					sb.insert(
							sb.toString()
									.toLowerCase()
									.lastIndexOf(
											(s.charAt(i) + "").toLowerCase()) + 1,
							s.charAt(i) + "");
				} else {
					sb.append(s.charAt(i));
				}
			}
		}

		int sum = 0;
		for (int i = 26; i > 0; i--) {
			if (sb.length() > 0)
				sum += i * findMax(sb);
			else
				break;
		}
		System.out.println(sum);
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
