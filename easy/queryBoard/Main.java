
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static int[][] createMatrix() {
		int[][] matrix = new int[256][256];
		for (int i = 0; i < 256; i++) {
			for (int j = 0; j < 256; j++) {
				matrix[i][j] = 0;
			}
		}
		return matrix;
	}

	public static int[][] modifyMatrix(String command, int rowOrCol, int val,
			int[][] matrix) {
		if (command.startsWith("SetCol")) {
			for (int i = 0; i < 256; i++) {
				matrix[i][rowOrCol] = val;
			}
		} else if (command.startsWith("SetRow")) {
			for (int i = 0; i < 256; i++) {
				matrix[rowOrCol][i] = val;
			}
		}
		return matrix;
	}

	public static int[][] readCommand(String command, int[][] matrix) {
		int rowOrCol = 0;
		int val = 0;
		String[] cmds = command.split(" ");
		rowOrCol = Integer.valueOf(cmds[1]);
		val = Integer.valueOf(cmds[2]);
		matrix = modifyMatrix(command, rowOrCol, val, matrix);
		return matrix;
	}

	public static int calculateSum(String command, int[][] matrix){
		int sum = 0;
		String[] cmds = command.split(" ");
		int rowOrCol = Integer.valueOf(cmds[1]);
		if (command.contains("Row")){
			for (int i = 0; i < 256; i++){
				sum += matrix[rowOrCol][i];
			}
		}else{
			for (int i = 0; i < 256; i++){
				sum += matrix[i][rowOrCol];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			int[][] matrix = createMatrix();
			while ((line = reader.readLine()) != null) {
				if (!line.startsWith("Query")) {
					matrix = readCommand(line, matrix);
				} else {
					System.out.println(calculateSum(line, matrix));
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
