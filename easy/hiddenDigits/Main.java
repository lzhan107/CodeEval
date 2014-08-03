
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static char getHiddenDigitChar(char ch) {
		char digitChar = 0;
		switch (ch) {
		case 'a':
			digitChar = '0';
			break;
		case 'b':
			digitChar = '1';
			break;
		case 'c':
			digitChar = '2';
			break;
		case 'd':
			digitChar = '3';
			break;
		case 'e':
			digitChar = '4';
			break;
		case 'f':
			digitChar = '5';
			break;
		case 'g':
			digitChar = '6';
			break;
		case 'h':
			digitChar = '7';
			break;
		case 'i':
			digitChar = '8';
			break;
		case 'j':
			digitChar = '9';
			break;
		default:
			break;
		}

		return digitChar;
	}

	public static void resolve(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 96 && s.charAt(i) < 107)
				sb.append(getHiddenDigitChar(s.charAt(i)));
			if (Character.isDigit(s.charAt(i)))
				sb.append(s.charAt(i));
		}
		if (sb.length() > 0)
			System.out.println(sb);
		else
			System.out.println("NONE");
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