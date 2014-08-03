
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		String[] data = s.split(" ");
		int maxLength = 0;
		int idx = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length() > maxLength) {
				maxLength = data[i].length();
				idx = i;
			}
		}
		return data[idx];
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