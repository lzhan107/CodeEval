
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static boolean resolve(String s) {
		int temp = Integer.valueOf(s);
		int val = temp;
		int numOfDigits = s.length();
		double sum = 0;
		while (temp > 0) {
			double power = Math.pow(temp % 10, numOfDigits);
			sum += power;
			temp = temp / 10;
		}
		return val == sum;
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				if (resolve(line))
					System.out.println("True");
				else
					System.out.println("False");
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
