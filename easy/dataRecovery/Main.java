
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int getWordIndex(String[] arr, int count) {
		for (int i = 0; i < arr.length; i++) {
			if (count == Integer.valueOf(arr[i]))
				return i;
		}
		return -1;
	}

	public static String resolve(String s) {
		String[] dataSet = s.split(";");
		String[] words = dataSet[0].split(" ");
		String[] nums = dataSet[1].split(" ");

		StringBuilder sb = new StringBuilder();
		int count = 1;

		while (count <= words.length) {
			int wordIdx = getWordIndex(nums, count);
			if (wordIdx != -1)
				sb.append(words[wordIdx]).append(" ");
			else
				sb.append(words[words.length - 1]).append(" ");
			count++;
		}

		return sb.toString();
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