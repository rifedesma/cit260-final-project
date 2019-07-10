import java.util.NoSuchElementException;
import java.util.Scanner;

/** Displays menus 
 * 
 * @author Purnell Darrell
 *
 */
public class DisplayMenu {

	private static Scanner input = new Scanner(System.in);
	
	private DisplayMenu()
	{
		
	}
	
	public static int displayAndPromptLibraryMenu()
	{
		System.out.println("Libraries:");
		System.out.println("");
		System.out.println("1 - Music");
		System.out.println("2 - Movies");
		System.out.println("3 - Books");
		System.out.println("4 - Quit");
		System.out.println("");
		
		//prompt for the library option
		return PromptUser.promptForInteger("Select library (by number): ");
	}
	
	public static int displayAndPromptEntryViewMenu()
	{
		System.out.println("1 - Enter entries");
		System.out.println("2 - View entries");
		System.out.println("3 - Back to library selection menu");
		System.out.println("");
		
		//prompt for the library option
		return PromptUser.promptForInteger("Select option (by number): ");
	}
	
	
	public static void promptForEntry(Book book)
	{
		System.out.println("Book");
		System.out.println("");
		System.out.print("Title name: ");
		book.setTitleName(input.next());

		System.out.print("Author name: ");
		book.setAuthorName(input.next());
		
		System.out.print("format (Hard, Soft, Audio): ");
		book.setFormat(input.next());
		
		System.out.print("ISBN: ");
		book.setIsbn(input.next());
	}
	
	
	public static String promptForView()
	{
		String quit = "";
		try
		{
			System.out.print("");
			System.out.print("Enter 'q' to go back to options menu: ");
			quit = input.next();
			if (!quit.equalsIgnoreCase("q"))
			{
				System.out.print("Must enter 'q' to go back.");
				input.nextLine();
				quit = promptForView();
			}
		}catch (NoSuchElementException nosuch)
		{
			System.out.print("Must enter 'q' to go back.");
			input.nextLine();
			quit = promptForView();
		}
		return quit;
	}
}
