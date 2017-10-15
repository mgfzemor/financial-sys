package general;

import java.util.Scanner;

public class CmdInput implements Input {

	/**
	 * @see general.Input#getString()
	 */
	@Override
	public String getString() {
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		return input;
	}

	/**
	 * @see general.Input#getInt()
	 */
	@Override
	public int getInt() {
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		return input;
	}
	
	/**
	 * @see general.Input#getFloat()
	 */
	@Override
	public float getFloat() {
		Scanner reader = new Scanner(System.in);
		float input = reader.nextFloat();
		return input;
	}
}
