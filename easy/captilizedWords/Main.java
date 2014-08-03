
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		int spaceIdx = s.indexOf(" ");
		if (spaceIdx == -1)
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		String word = s.substring(0, 1).toUpperCase()
				+ s.substring(1, spaceIdx);
		return word + " " + resolve(s.substring(spaceIdx + 1));
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
