
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String s) {
		String[] dataSet = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dataSet.length; i = i + 2) {
			if ("0".equals(dataSet[i]))
				sb.append(dataSet[i + 1]);
			else
				sb.append(dataSet[i + 1].replaceAll("0", "1"));
		}
		System.out.println(Long.valueOf(sb.toString(), 2));
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