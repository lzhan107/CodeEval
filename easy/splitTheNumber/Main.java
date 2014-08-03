
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int calculate(String number, int leftOperandLength,
			String action) {
		int leftOperand = Integer.valueOf(number
				.substring(0, leftOperandLength));
		int rightOperand = Integer.valueOf(number.substring(leftOperandLength));

		if (action.equals("+"))
			return leftOperand + rightOperand;
		return leftOperand - rightOperand;
	}

	public static void resolve(String s) {
		String[] dataSet = s.split(" ");
		String[] patterns;
		if (dataSet[1].contains("-")) {
			patterns = dataSet[1].split("\\-");
			System.out
					.println(calculate(dataSet[0], patterns[0].length(), "-"));
		} else if (dataSet[1].contains("+")) {
			patterns = dataSet[1].split("\\+");
			System.out
					.println(calculate(dataSet[0], patterns[0].length(), "+"));
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