
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void resolve(String s) {
		String[] data = s.split(" ");
		
		for (int i = 0; i < data.length; i++){
			for (int j = 0; j < data.length - i - 1; j++){
				if (Float.parseFloat(data[j]) > Float.parseFloat(data[j+1])){
					String temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < data.length; i++){
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
