
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static int getMonthNumber(String month) {
		int monthNumber = 0;
		switch (month) {
		case "Jan":
			monthNumber = 1;
			break;
		case "Feb":
			monthNumber = 2;
			break;
		case "Mar":
			monthNumber = 3;
			break;
		case "Apr":
			monthNumber = 4;
			break;
		case "May":
			monthNumber = 5;
			break;
		case "Jun":
			monthNumber = 6;
			break;
		case "Jul":
			monthNumber = 7;
			break;
		case "Aug":
			monthNumber = 8;
			break;
		case "Sep":
			monthNumber = 9;
			break;
		case "Oct":
			monthNumber = 10;
			break;
		case "Nov":
			monthNumber = 11;
			break;
		case "Dec":
			monthNumber = 12;
			break;
		default:
			break;
		}
		return monthNumber;
	}

	private static class Time implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {

			if (Integer.valueOf(s1.substring(4, 8)) < Integer.valueOf(s2
					.substring(4, 8)))
				return -1;

			if (Integer.valueOf(s1.substring(4, 8)) > Integer.valueOf(s2
					.substring(4, 8)))
				return 1;

			if (getMonthNumber(s1.substring(0, 3)) < getMonthNumber(s2
					.substring(0, 3)))
				return -1;

			if (getMonthNumber(s1.substring(0, 3)) > getMonthNumber(s2
					.substring(0, 3)))
				return 1;
			return 0;
		}
	}

	public static int resolve(String s) {
		String[] workingPeriods = s.split("; ");
		Arrays.sort(workingPeriods, new Time());
		int months = 0;
		int preStartTime = 30 * 12 + 12;// Dec 2020
		int preEndTime = 1;// Jan 1990

		for (int i = 0; i < workingPeriods.length; i++) {
			String[] startAndEnd = workingPeriods[i].split("-");
			int currStartTime = (Integer
					.valueOf(startAndEnd[0].substring(4, 8)) - 1990)
					* 12
					+ getMonthNumber(startAndEnd[0].substring(0, 3));
			int currEndTime = (Integer.valueOf(startAndEnd[1].substring(4, 8)) - 1990)
					* 12 + getMonthNumber(startAndEnd[1].substring(0, 3));

			months += currEndTime - currStartTime + 1;
			if (currStartTime > preEndTime || currEndTime < preStartTime) {
				preStartTime = currStartTime;
				preEndTime = currEndTime;
				continue;
			}

			int overLappingTime = 0;
			if (currEndTime <= preEndTime) {
				overLappingTime = currEndTime - currStartTime + 1;
			} else if (currStartTime <= preEndTime) {
				overLappingTime = preEndTime - currStartTime + 1;
			}
			months -= overLappingTime;
		}
		return months / 12;
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