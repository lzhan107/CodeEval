
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String[] swap(String[] data, String a, String b) {
		String temp = data[Integer.valueOf(a)];
		data[Integer.valueOf(a)] = data[Integer.valueOf(b)];
		data[Integer.valueOf(b)] = temp;
		return data;
	}

	public static void resolve(String s) {
		String[] ss = s.split(" : ");
		String[] data = ss[0].split(" ");
		String[] positions;

		if (ss[1].contains(",")) {
			positions = ss[1].split(", ");
		} else {
			positions = new String[1];
			positions[0] = ss[1];
		}

		for (int i = 0; i < positions.length; i++) {
			String[] movements = positions[i].split("-");
			data = swap(data, movements[0], movements[1]);
		}

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
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