
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	/**
	 * Approach 1: Using HashMap
	 * 
	 * @param s
	 * @return
	 */
	/*
	 * public static String resolve(String s) { String[] dataSet = s.split(",");
	 * Map<String, Integer> dataMap = new HashMap<>();
	 * 
	 * for (int i = 0; i < dataSet.length; i++) { if (dataMap.get(dataSet[i]) ==
	 * null) dataMap.put(dataSet[i], 1); else { dataMap.put(dataSet[i],
	 * dataMap.get(dataSet[i]) + 1); } }
	 * 
	 * for (Map.Entry<String, Integer> entry : dataMap.entrySet()) { Integer
	 * times = entry.getValue(); if (times > dataSet.length / 2) return
	 * entry.getKey(); } return "None"; }
	 */

	/**
	 * Approach 2: Sorting the array first
	 * 
	 * @param s
	 * @return
	 */
	public static String resolve(String s) {
		String[] dataSet = s.split(",");
		Arrays.sort(dataSet);
		int counter = 1;
		for (int i = 1; i < dataSet.length; i++) {
			if (dataSet[i].equals(dataSet[i - 1])) {
				counter++;
			} else {
				if (counter > dataSet.length / 2) {
					return dataSet[i - 1];
				}
				counter = 1;
			}
		}
		return "None";
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