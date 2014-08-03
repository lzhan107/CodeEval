
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static boolean isUnique(char[] arr, char element) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (element == arr[i])
				count++;
		}
		return count == 1;
	}

	public static char findLowest(char[] arr) {
		char lowest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < lowest)
				lowest = arr[i];
		}
		return lowest;
	}

	public static int resolve(String s) {
		char[] data = s.replaceAll(" ", "").toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < data.length; i++) {
			if (isUnique(data, data[i]))
				sb.append(data[i]);
		}

		if (sb.length() == 0)
			return 0;

		char lowest = findLowest(sb.toString().toCharArray());

		int position = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == lowest)
				position = i + 1;
		}
		return position;
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
