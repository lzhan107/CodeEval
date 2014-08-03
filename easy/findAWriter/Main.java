
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		String[] data = s.split("\\|");
		String[] keys = data[1].trim().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keys.length; i++){
			sb.append(s.charAt(Integer.valueOf(keys[i])-1));
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
