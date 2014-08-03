
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int[] getData(String line) {
		String[] results = line.split(",");
		int[] res = new int[results.length];
		for (int i = 0; i < results.length; i++) {
			res[i] = Integer.valueOf(results[i]);
		}
		return res;
	}

	public static void resolve(int n, int p1, int p2) {
		char[] s = Integer.toBinaryString(n).toCharArray();
		if (s[s.length - p1] == s[s.length - p2])
			System.out.println("true");
		else
			System.out.println("false");
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				int[] data = getData(line);
				resolve(data[0], data[1], data[2]);
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
