//Author: Pavel Trubchik

import java.util.Scanner;

public class Minesweeper {
	public static void main(String[] args) {
		int fieldCount = 0;
		char[][] mineField;
		Scanner scanner = new Scanner(System.in);

		do {
			mineField = getNextMineField(scanner);
			
			if (mineField.length - 2 > 0 && mineField[0].length - 2 > 0) {
				calculateMineAdjacentCells(mineField);
				fieldCount++;
				System.out.println("Field #" + fieldCount);
				printMineField(mineField);
			}
			
		} while (mineField.length - 2 > 0 && mineField[0].length - 2 > 0);

		scanner.close();
	}
	
	public static char[][] getNextMineField(Scanner scanner) {	
		String inputLine = scanner.nextLine();
		int x = Integer.parseInt(inputLine.split(" ")[0]);
		int y = Integer.parseInt(inputLine.split(" ")[1]);
		char[][] mineField = new char[x + 2][y + 2];
		
		for (int i = 1; i < mineField.length - 1; i++) {
			inputLine = scanner.nextLine();
			char[] inputChars = inputLine.toCharArray();
			
			for (int j = 1; j < mineField[i].length - 1; j++) {
				if (inputChars[j - 1] == '*') {
					mineField[i][j] = '*';
				} else {
					mineField[i][j] = '0';
				}
			}
		}
		
		return mineField;
	}

	public static void calculateMineAdjacentCells(char[][] mineField) {
		for (int i = 1; i < mineField.length - 1; i++) {
			for (int j = 1; j < mineField[i].length - 1; j++) {
				if (mineField[i][j] == '*') {
					incrementAdjacentNonMines(mineField, i, j);
				}
			}
		}
	}
	
	public static void incrementAdjacentNonMines(char[][] mineField, int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (mineField[i][j] != '*') {
					mineField[i][j]++;
				}
			}
		}
	}
	
	public static void printMineField(char[][] mineField) {
		for (int i = 1; i < mineField.length - 1; i++) {
			for (int j = 1; j < mineField[i].length - 1; j++) {
				System.out.print(mineField[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
