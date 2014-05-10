package CardGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;



public class InBetweenGameTest {

	InBetweenGame game = new InBetweenGame();
	private BufferedReader br;
	
	/**
	 * This file test startGame with an input file "test.data".
	 * Also, it will generate all the output to "output-file.txt"
	 * It will also generate the statistics of testing result. 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void startGameTest() throws NumberFormatException, IOException {
		FileInputStream is =new FileInputStream(new File("src/CardGame/test.data"));
		System.setIn(is);
		System.setOut(new PrintStream(new File("src/CardGame/output-file.txt")));
		
		game.startGame();
	    

		FileInputStream fis = new FileInputStream(new File("src/CardGame/output-file.txt"));
		br = new BufferedReader(new InputStreamReader(fis));
		
		String line = br.readLine();
		int index = 0;
		int[] result = new int[13];
		int winSum = 0;
		int gameSum = 0;
		
		
		while (line != null) {
			if (line.indexOf("Your card is") != -1) {
				int commaPos = line.indexOf("\"");
				String num = line.substring(commaPos + 1, line.indexOf(" ", commaPos));
				if (num.equals("Ace"))
					index = 1;
				else if (num.equals("Jack"))
					index = 11;
				else if (num.equals("Queen"))
					index = 12;
				else if (num.equals("King"))
					index = 13;
				else index = Integer.parseInt(num);
			}
			
			if (line.indexOf("You Win") != -1) {
				gameSum++;
				winSum++;
				result[index - 1]++; 
			}
			else if (line.indexOf("You Lose") != -1) {
				gameSum++;
			}
			line = br.readLine();
		}
		
		System.setOut(new PrintStream(new File("src/CardGame/statistics.txt")));
		System.out.print("Result Statistics in " + gameSum + " games, win: " + winSum + " games\n");
		for (int i = 0; i < 13; i++) {
			System.out.println((i + 1) + " : " + result[i]);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		InBetweenGameTest gameTest = new InBetweenGameTest();
		gameTest.startGameTest();
		
	}
	
	
}
