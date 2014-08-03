
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int resolve(String s) {

		for (int i = 0; i < s.length(); i++) {
			int posVal = Character.getNumericValue(s.charAt(i));
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if (i == Character.getNumericValue(s.charAt(j)))
					count++;
			}
			if (count != posVal)
				return 0;
		}

		return 1;
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
