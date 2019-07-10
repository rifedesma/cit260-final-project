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
		System.out.println("");
		System.out.println("1 - Enter entries");
		System.out.println("2 - View entries");
		System.out.println("3 - Back to library selection menu");
		System.out.println("");
		
		//prompt for the library option
		return PromptUser.promptForInteger("Select option (by number): ");
	}
	
	
	public static void promptForEntry(Book book, Library library)
	{
		System.out.println("Book");
		System.out.println("");
		promptForTitle(book);

		promptForAuthor(book);
		
		promptFormatItem(book);
			
		promptForISBN(book);
		
		((BooksLibrary)library).print();
	}

	/** prompt for ISBN and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForISBN(Book book) {
		System.out.print("ISBN: ");
		String isbn = input.nextLine();
		if (isbn.equals(""))
		{
			System.out.println("ISBN cannot be blank.");
			input.hasNextLine();
			promptForISBN(book);
		}else
		{
			book.setIsbn(isbn);
		}
	}

	/** prompt for author and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForAuthor(Book book) {
		System.out.print("Author name: ");
		String author = input.nextLine();
		if (author.equals(""))
		{
			System.out.println("Author cannot be blank.");
			input.hasNextLine();
			promptForAuthor(book);
		}else
		{
			book.setAuthorName(author);
		}
	}

	/** prompt for title and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForTitle(Book book) {
		System.out.print("Title name: ");
		String title = input.nextLine();
		if (title.equals(""))
		{
			System.out.println("Title cannot be blank.");
			input.hasNextLine();
			promptForTitle(book);
		}else 
		{
			book.setTitleName(title);
		}
	}

	/** prompt for format item and saved to book object
	 * 
	 * @param book
	 */
	private static void promptFormatItem(Book book) {
		System.out.print("format (Hard, Soft, Audio): ");
		String format = input.nextLine();
		if (!format.equalsIgnoreCase("hard") && 
				!format.equalsIgnoreCase("soft") &&
				!format.equalsIgnoreCase("audio"))
		{
			System.out.println("Format must be either 'Hard, Soft or Audio'.");
			promptFormatItem(book);
		}else
		{
			
			book.setFormat(format);
		}
	}
	
	
	public static String promptForView()
	{
		String quit = "";
		try
		{
			System.out.println("");
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
