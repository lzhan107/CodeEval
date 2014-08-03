
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void printTrip(int min, int nextMin) {
		System.out.println(nextMin - min + ",");
	}

	public static void resolve(String s) {
		String[] dataSet = s.split(";");
		int[] distances = new int[dataSet.length];
		int min = 30000;
		for (int i = 0; i < dataSet.length; i++) {
			String[] trips = dataSet[i].split(",");
			int distance = Integer.valueOf(trips[1]);
			if (distance < min)
				min = distance;
			distances[i] = distance;
		}

		printTrip(0, min);
		int nextMin = 30000;
		int x = distances.length - 1;
		while (x-- > 0) {
			for (int i = 0; i < distances.length; i++) {
				if (distances[i] != min && distances[i] < nextMin)
					nextMin = distances[i];
			}
			printTrip(min, nextMin);
			min = nextMin;
			nextMin = 30000;
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