
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			StringBuilder data = new StringBuilder();
			int ch;
			String labelPattern = "label";
			String idPattern = "id";
			String numberPattern = "\\d+";

			Pattern labelRegex = Pattern.compile(labelPattern);
			Pattern numberRegex = Pattern.compile(numberPattern);
			Matcher labelRegexMatcher, numberRegexMatcher;

			int sum = 0;

			while ((ch = reader.read()) != -1) {
				data.append((char) ch);
				labelRegexMatcher = labelRegex.matcher(data);

				if (labelRegexMatcher.find()) {
					int start = data.lastIndexOf(idPattern);
					int end = labelRegexMatcher.start();

					numberRegexMatcher = numberRegex.matcher(data.substring(
							start, end));
					if (numberRegexMatcher.find()) {
						sum += Integer.valueOf(numberRegexMatcher.group());
						data.delete(0, data.length());
					}
				}

				if (ch == ']'){
				  System.out.println(sum);
				  sum = 0;
				}
					
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