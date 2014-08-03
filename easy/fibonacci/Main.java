
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main{

	public static int getData(String line) {
		return Integer.valueOf(line);
	}

	public static int fibonacci(int data){
		if (data == 0)
			return 0;
		if (data == 1)
			return 1;
		return fibonacci(data - 1) + fibonacci(data -2);
	}
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
		    while ((line = reader.readLine()) != null) {
		        int data = getData(line);
		        System.out.println(fibonacci(data));
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