

import java.util.StringTokenizer;

/** Library base class for library object
 * 
 * @author Purnell Darrell
 *
 */
public class Library {

		
	protected Library()
	{
		
	}
	
	
	/** display the library menu
	 * 
	 * @return
	 */
	protected static int displayAndPromptLibraryMenu() {
		// display and prompt for menu value
		int library = DisplayMenu.displayAndPromptLibraryMenu();
		
		if (library <= 0 || library >= 5)
		{
			System.out.println("Must enter a valid library number.");
			displayAndPromptLibraryMenu();
		}
		
		return library;
	}

	
	
	/** method to return to the library menu from Entry/View menu
	 * 
	 */
	public static void libraryMenu()
	{
		int libraryNumber = displayAndPromptLibraryMenu();
		
		createLibrary(libraryNumber);
		
	}


	/** Create derived class of Library and invoke its execution method
	 * 
	 * @param library
	 */
	private static void createLibrary(int library)
	{
		Library libraryObj = null;
		
		switch (library)
		{
			//Music
			case 1:
				libraryObj = new MusicLibrary();
                ((MusicLibrary)libraryObj).processMusicLibrary(libraryObj);
				break;
			//Movies
			case 2:
			    libraryObj = new MoviesLibrary();
                ((MoviesLibrary)libraryObj).processMoviesLibrary(libraryObj);
				break;
			//Books
			case 3:
				libraryObj = new BooksLibrary();
				((BooksLibrary)libraryObj).processBooksLibrary(libraryObj);
				break;
			default:
				//quit application, do nothing
		}
	
	}
	
	
	/** parse the line into array of strings
	 * 
	 * @param line
	 * @return
	 */
	protected static String[] parseLineToElementsArray(String line) {
		String[] elements = new String[4];
		StringTokenizer tokenizer = new StringTokenizer(line, "|");
		int i = 0;
		while (tokenizer.hasMoreElements())
		{
			elements[i] = (String)tokenizer.nextElement();
			i++;
		}
		return elements;
	}
	
}
