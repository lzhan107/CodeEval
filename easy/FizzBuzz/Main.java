
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main{

	public static int[] getData(String line) {
		String[] results = line.split(" ");
		int[] res = new int[results.length];
		for (int i = 0; i < results.length; i++) {
			res[i] = Integer.valueOf(results[i]);
		}
		return res;
	}

	public static void resolve(int A, int B, int N) {
		for (int i = 1; i <= N; i++) {
			if (i % A == 0 && i % B == 0) {
				System.out.print("FB ");
			} else if (i % A == 0) {
				System.out.print("F ");
			} else if (i % B == 0) {
				System.out.print("B ");
			} else {
				System.out.print(i + " ");
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
		        int[] data = getData(line);
		        resolve(data[0], data[1], data[2]);
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
