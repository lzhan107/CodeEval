
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String data) {
		String[] list = data.split(",");
		for (int i = list[0].length()-1; i >= 0; i--){
			if (list[0].charAt(i) == list[1].charAt(0)){
				System.out.println(i);
				break;
			}
			if (i == 0)
				System.out.println(-1);
		}
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
