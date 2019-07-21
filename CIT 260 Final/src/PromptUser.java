import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** PromptUser class 
 * used for both A12dot2 and A12dot3 classes
 * And now the Final project
 */
public class PromptUser {

	
	private static Scanner input = new Scanner(System.in);
	
	public PromptUser()
	{
		
	}
	
	
	/** Prompt user for an integer, by displaying message provided
	 * 
	 * @param message
	 * @return
	 */
	public static int promptForInteger(String message)
	{
		int value = 0;
		try {
			System.out.print(message);
			value = input.nextInt();
		}catch (InputMismatchException mismatchException)
		{
			System.out.println("Must enter a whole integer value, no period.");
			input.nextLine();
			value = promptForInteger(message);
		}catch (NoSuchElementException noElement)
		{
			System.out.println("Must enter a whole integer value, no period.");
			input.nextLine();
			value = promptForInteger(message);
		}
		
		return value;
	}
	
	/** Prompt user for a string (includes spaces) and retrieve the entire line
	 * 
	 * @param message
	 * @return
	 */
	public static String promptForLine(String message)
	{
		String line = "";
		try {
			System.out.print(message);
			line = input.nextLine();
		}finally
		{
			
		}
		
		
		return line;
	}
	
	/** Prompt User for a string (single word)
	 * 
	 * @param message
	 * @return
	 */
	public static String promptForString(String message)
	{
		String value = "";
		try {
			System.out.print(message);
			value = input.next();
		}catch (NoSuchElementException nosuch)
		{
			System.out.println("Must enter a value, cannot be blank.");
			input.nextLine();
		}
		
		return value;
	}
	
}
