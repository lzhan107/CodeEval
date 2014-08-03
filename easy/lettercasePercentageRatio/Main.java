
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String s) {
				double lowercaseNums = 0;
		double uppercaseNums = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i)))
				uppercaseNums++;
			else
				lowercaseNums++;
		}

		System.out.format("lowercase: %.2f uppercase: %.2f", lowercaseNums
				/ (lowercaseNums + uppercaseNums)*100, uppercaseNums
				/ (lowercaseNums + uppercaseNums)*100);
		System.out.println();
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