
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main{

	public static String[] getData(String line) {
		String[] results = line.split(" ");
		return results;
	}

	public static void resolve(String[] data) {
		for (int i = 0; i < data.length; i++){
			System.out.print(data[i].toLowerCase() + " ");
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
		        String[] data = getData(line);
		        resolve(data);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    
	}
}