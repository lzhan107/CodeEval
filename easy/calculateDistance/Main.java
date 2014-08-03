
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int resolve(String s) {
		String pattern = "\\)|\\(\\s*|,\\s*";
		String[] data = s.split(pattern);
		double a = Double.valueOf(data[1]);
		double b = Double.valueOf(data[2]);
		double c = Double.valueOf(data[4]);
		double d = Double.valueOf(data[5]);
		return (int)Math.sqrt((a - c) * (a - c) + (b - d) * (b - d));
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
