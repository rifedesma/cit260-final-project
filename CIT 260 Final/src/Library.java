/** Library base class for library object
 * 
 * @author Purnell Darrell
 *
 */
public class Library {

	protected Library()
	{
		
	}
	
	

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

	
	public static void processBookLibrary(Library libraryObj)
	{
		int entryViewNumber = DisplayMenu.displayAndPromptEntryViewMenu();
		
		if (entryViewNumber <= 0 || entryViewNumber >= 4)
		{
			System.out.println("Must enter a valid option number.");
			processBookLibrary(libraryObj);
		}
		
		if (entryViewNumber == 1)
		{
			((BooksLibrary)libraryObj).promptForEntry();
		} else if (entryViewNumber == 2)
		{
			((BooksLibrary)libraryObj).promptForView();
		} else
		{
			libraryMenu();
		}
	}
	
	public static void libraryMenu()
	{
		int libraryNumber = displayAndPromptLibraryMenu();
		
		createLibrary(libraryNumber);
		
	}



	private static void createLibrary(int library)
	{
		Library libraryObj = null;
		
		switch (library)
		{
			//Music
			case 1:
				
				break;
			//Movies
			case 2:
			
				break;
			//Books
			case 3:
				libraryObj = new BooksLibrary();
				Library.processBookLibrary(libraryObj);
				break;
			default:
				//quit application, do nothing
		}
	
	}
	
	
}
