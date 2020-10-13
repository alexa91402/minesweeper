import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Random rn = new Random();
		int round = 1;
		int score = 0;
		String[][] map = new String[5][5];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = "_";
			}
		}
		String[][] hiddenMap = new String[5][5];
		for(int i = 0; i < hiddenMap.length; i++) {
			for(int j = 0; j < hiddenMap[i].length; j++) {
				hiddenMap[i][j] = "S";
			}
		}
		for(int i = 0; i < 5; i++) {
				hiddenMap[rn.nextInt(((4 - 0) + 1))][rn.nextInt(((4 - 0) + 1))] = "B";
		}
		
		mineSweeper(map, hiddenMap, round, score);

	}
	
	public static void mineSweeper(String[][] map, String[][] hidden, int round, int score) {
		System.out.println("Our field for round " + round);
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a position to sweep for mines: ");
		int input = scan.nextInt();
		int input2 = scan.nextInt();
		if(input > 4 || input2 > 4) {
			System.out.println("That is an invalid position, please enter a position between 0 and 4 for the row and column.");
		}
		else {
			if(hidden[input][input2].equals("B")) {
				System.out.println("Sorry! You stepped on a mine in round " + round + ". You had " + score + " points.\nThe actual field:");
				for(int i = 0; i < hidden.length; i++) {
					for(int j = 0; j < hidden[i].length; j++) {
						System.out.print(hidden[i][j]);
					}
					System.out.println();
				}
			}
			else {
				map[input][input2] = "S";
				score++;
				round++;
				mineSweeper(map, hidden, round, score);
			}
		}
	}

}
