
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		String[] dataSet = s.split(",");
		StringBuilder words = new StringBuilder();
		StringBuilder numbers = new StringBuilder();
		for (int i = 0; i < dataSet.length; i++) {
			if (Character.isAlphabetic(dataSet[i].charAt(0)))
				words.append(dataSet[i]).append(",");
			else
				numbers.append(dataSet[i]).append(",");
		}

		String result = "";

		if (words.length() > 0 && numbers.length() > 0) {
			result = words.substring(0, words.length() - 1) + "|"
					+ numbers.substring(0, numbers.length() - 1);
		} else if (words.length() > 0) {
			result += words.substring(0, words.length() - 1);
		} else {
			result += numbers.substring(0, numbers.length() - 1);
		}

		return result;
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