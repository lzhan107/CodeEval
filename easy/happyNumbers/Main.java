
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int resolve(int n) {
		//If n is 1, return 1
		if (n == 1)
			return n;
		int squareSum = 0;
		int temp = n;//temp variable to hold original value
		while (n > 0) {
			squareSum += (n % 10) * (n % 10);
			n = n / 10;
		}
		//If original is a multiple of 10, check the value of squareSum
		//The value of squareSum should be 10, 100, 1000... If not, return 0.
		//Can not be 1, because we need to return 1 at the beginning.
		if (temp % 10 == 0)
			if (squareSum != 1 && squareSum % 10 != 0)
				return 0;
		return resolve(squareSum);
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(resolve(Integer.valueOf(line)));
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
