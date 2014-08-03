
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<String, Character> numRefMap = new HashMap<>();

	static {
		numRefMap.put(".-", 'A');
		numRefMap.put("-...", 'B');
		numRefMap.put("-.-.", 'C');
		numRefMap.put("-..", 'D');
		numRefMap.put(".", 'E');
		numRefMap.put("..-.", 'F');
		numRefMap.put("--.", 'G');
		numRefMap.put("....", 'H');
		numRefMap.put("..", 'I');
		numRefMap.put(".---", 'J');
		numRefMap.put("-.-", 'K');
		numRefMap.put(".-..", 'L');
		numRefMap.put("--", 'M');
		numRefMap.put("-.", 'N');
		numRefMap.put("---", 'O');
		numRefMap.put(".--.", 'P');
		numRefMap.put("--.-", 'Q');
		numRefMap.put(".-.", 'R');
		numRefMap.put("...", 'S');
		numRefMap.put("-", 'T');
		numRefMap.put("..-", 'U');
		numRefMap.put("...-", 'V');
		numRefMap.put(".--", 'W');
		numRefMap.put("-..-", 'X');
		numRefMap.put("-.--", 'Y');
		numRefMap.put("--..", 'Z');
		numRefMap.put(".----", '1');
		numRefMap.put("..---", '2');
		numRefMap.put("...--", '3');
		numRefMap.put("....-", '4');
		numRefMap.put(".....", '5');
		numRefMap.put("-....", '6');
		numRefMap.put("--...", '7');
		numRefMap.put("---..", '8');
		numRefMap.put("----.", '9');
		numRefMap.put("-----", '0');
	}

	public static void resolve(String s) {
		String[] dataSet = s.split("  ");
		
		for (int i = 0; i < dataSet.length; i++){
			String[] data = dataSet[i].split(" ");
			for (int j = 0; j < data.length; j++){
				System.out.print(numRefMap.get(data[j]));
			}
			System.out.print(" ");
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