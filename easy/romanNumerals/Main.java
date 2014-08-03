
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map<Integer, String> numRefMap = new HashMap<>();
	static {
		numRefMap.put(1, "I");
		numRefMap.put(5, "V");
		numRefMap.put(10, "X");
		numRefMap.put(50, "L");
		numRefMap.put(100, "C");
		numRefMap.put(500, "D");
		numRefMap.put(1000, "M");
	}

	public static String resolve(String s) {
		int data = Integer.valueOf(s);
		StringBuilder sb = new StringBuilder();
		for (int i = 1000; i > 0; i = i / 10) {
			int multipler = data / i;
			if (multipler > 0) {
				String digit = numRefMap.get(i);
				String fifth = numRefMap.get(5 * i);
				String tenth = numRefMap.get(10 * i);

				if (multipler < 4) {
					for (int j = 0; j < multipler; j++) {
						sb.append(digit);
					}
				} else if (multipler == 4) {
					sb.append(digit).append(fifth);
				} else if (multipler == 5) {
					sb.append(fifth);
				} else if (multipler >= 6 && multipler <= 8) {
					sb.append(fifth);
					for (int j = 0; j < multipler - 5; j++) {
						sb.append(digit);
					}
				} else {
					sb.append(digit).append(tenth);
				}

				data = data - i * multipler;
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
