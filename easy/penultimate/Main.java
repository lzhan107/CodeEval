
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String s) {
		int end = s.lastIndexOf(" ");
		int start = s.substring(0, s.lastIndexOf(" ")).contains(" ") ? s
				.substring(0, s.lastIndexOf(" ")).lastIndexOf(" ") + 1: 0;
		System.out.println(s.substring(start, end + 1));
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
