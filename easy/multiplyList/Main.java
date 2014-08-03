
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String s) {
		String[] dataSet1 = s.substring(0, s.indexOf("|")).split(" ");
		String[] dataSet2 = s.substring(s.indexOf("|") + 1, s.length()).trim()
				.split(" ");
		for (int i = 0; i < dataSet1.length; i++) {
			System.out.print(Integer.valueOf(dataSet1[i])
					* Integer.valueOf(dataSet2[i]) + " ");
		}
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