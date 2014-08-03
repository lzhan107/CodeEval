
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map<String, Character> numRefMap = new HashMap<>();
	static {
		numRefMap.put("zero", '0');
		numRefMap.put("one", '1');
		numRefMap.put("two", '2');
		numRefMap.put("three", '3');
		numRefMap.put("four", '4');
		numRefMap.put("five", '5');
		numRefMap.put("six", '6');
		numRefMap.put("seven", '7');
		numRefMap.put("eight", '8');
		numRefMap.put("nine", '9');
	}

	public static String resolve(String s) {
		String[] data = s.split(";");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(numRefMap.get(data[i]));
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
