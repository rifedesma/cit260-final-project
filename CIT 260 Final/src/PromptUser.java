import java.util.InputMismatchException;
import java.util.Scanner;

/** PromptUser class 
 * used for both A12dot2 and A12dot3 classes
 */
public class PromptUser {

	
	private static Scanner input = new Scanner(System.in);
	
	public PromptUser()
	{
		
	}
	
	
	/** Prompt user for an integer, by displaying message provided */
	public static int promptForInteger(String message)
	{
		int value = 0;
		try {
			System.out.println(message);
			value = input.nextInt();
		}catch (InputMismatchException mismatchException)
		{
			System.out.println("Must enter a whole integer value, no period.");
			input.nextLine();
			value = promptForInteger(message);
		}
		
		return value;
	}
	
	
}