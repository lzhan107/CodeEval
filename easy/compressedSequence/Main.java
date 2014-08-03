
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String s) {
		String[] data = (s + " @").split(" ");
		int counter = 0;
		String currVal = data[0];
		for (int i = 0; i < data.length; i++) {
			if (currVal.equals(data[i])) {
				counter++;
			} else {
				System.out.print(counter + " " + currVal + " ");
				currVal = data[i];
				i--;
				counter = 0;
			}
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