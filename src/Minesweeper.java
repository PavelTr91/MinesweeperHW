import java.util.Scanner;

public class Minesweeper {
	public static void main(String[] args) {
		String inputLine;
		char[] inputChars;
		int fieldCount = 0;
		int x;
		int y;
		char[][] mineField;

		Scanner scanner = new Scanner(System.in);

		inputLine = scanner.nextLine();
		x = Integer.parseInt(inputLine.split(" ")[0]);
		y = Integer.parseInt(inputLine.split(" ")[1]);

		while (x != 0 && y != 0) {
			mineField = new char[x + 2][y + 2];
			fieldCount++;
			System.out.println("Field #" + fieldCount + "(" + x + "," + y + ")");

			for (int i = 1; i <= x; i++) {
				inputLine = scanner.nextLine();
				inputChars = inputLine.toCharArray();
				for (int j = 1; j <= y; j++) {
					if (inputChars[j - 1] == '*') {
						mineField[i][j] = '*';
					} else {
						mineField[i][j] = '0';
					}
				}
			}

			for (int i = 1; i <= x; i++) {
				for (int j = 1; j <= y; j++) {
					if (mineField[i][j] == '*') {
						incrementAdj(mineField, i, j);
					}
				}
			}

			outputToFile(mineField);
			
			inputLine = scanner.nextLine();
			x = Integer.parseInt(inputLine.split(" ")[0]);
			y = Integer.parseInt(inputLine.split(" ")[1]);
		}

		scanner.close();
	}

	public static void incrementAdj(char[][] mineField, int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (mineField[i][j] != '*') {
					mineField[i][j]++;
				}
			}
		}
	}
	
	public static void outputToFile(char[][] mineField) {
		for (int i = 1; i < mineField.length - 1; i++) {
			for (int j = 1; j < mineField[i].length - 1; j++) {
				System.out.print(mineField[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}
}
