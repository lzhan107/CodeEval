
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static String resolve(String s) {
		int age = Integer.valueOf(s);

		if (age >= 0 && age <= 2)
			return "Still in Mama's arms";
		if (age == 3 || age == 4)
			return "Preschool Maniac";
		if (age >= 5 && age <= 11)
			return "Elementary school";
		if (age >= 12 && age <= 14)
			return "Middle school";
		if (age >= 15 && age <= 18)
			return "High school";
		if (age >= 19 && age <= 22)
			return "College";
		if (age >= 23 && age <= 65)
			return "Working for the man";
		if (age >= 66 && age <= 100)
			return "The Golden Years";

		return "This program is for humans";
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