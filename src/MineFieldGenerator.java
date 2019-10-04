import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MineFieldGenerator {

	public static void main(String[] args) {
		String output = "";

		output = outputMineField(1, 1, 0, output);
		output = outputMineField(1, 100, 0, output);
		output = outputMineField(100, 1, 0, output);
		output = outputMineField(100, 100, 0, output);

		output = outputMineField(1, 1, 1, output);
		output = outputMineField(1, 100, 1, output);
		output = outputMineField(100, 1, 1, output);
		output = outputMineField(100, 100, 1, output);

		output = outputMineField(1, 100, 0.5, output);
		output = outputMineField(100, 1, 0.5, output);
		output = outputMineField(100, 100, 0.5, output);

		for (int count = 0; count < 10; count++) {
			int i = (int) (Math.random() * 100);
			int j = (int) (Math.random() * 100);
			output = outputMineField(i, j, 0.5, output);
		}

		writeToFile(output);
	}

	public static String outputMineField(int sizeX, int sizeY, double percentMines, String output) {
		char[][] mineField = new char[sizeX][sizeY];
		addMines(mineField, percentMines);
		return addToOutput(output, mineField);
	}

	public static void addMines(char[][] mineField, double percentMines) {
		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[i].length; j++) {
				double rand = Math.random();
				if (rand < percentMines) {
					mineField[i][j] = '*';
				} else {
					mineField[i][j] = '.';
				}
			}
		}
	}

	public static String addToOutput(String output, char[][] mineField) {
		output += mineField.length + " " + mineField[0].length + "\n";

		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[i].length; j++) {
				output += mineField[i][j];
			}
			output += "\n";
		}

		return output;
	}

	public static void writeToFile(String output) {
		File file = new File("input.txt");
		try {
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(output.getBytes());
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
