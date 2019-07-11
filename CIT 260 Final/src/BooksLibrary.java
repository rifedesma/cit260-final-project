import java.io.File;
import java.util.ArrayList;
import java.util.List;


/** Creates BooksLibrary object
 * 
 * @author Purnell Darrell
 *
 */
public class BooksLibrary extends Library {

	private static final String FILE_NAME = "Books.txt";
	private List<Media> booksLibrary = null;
	private Book book = null;
	
	public BooksLibrary()
	{
		super();
	}
	
	
	/** Displays the Prompt Entry/View menu and
	 * execute them on the BooksLibrary object.
	 * @param libraryObj
	 */
	public void processBooksLibrary(Library libraryObj)
	{
		int entryViewNumber = DisplayMenu.displayAndPromptEntryViewMenu();
		
		if (entryViewNumber <= 0 || entryViewNumber >= 4)
		{
			System.out.println("Must enter a valid option number.");
			processBooksLibrary(libraryObj);
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
	
	/** prompt for Book entry fields
	 * 
	 */
	public void promptForEntry()
	{
		book = new Book();
		DisplayMenu.promptForEntry(book, this);
		processBooksLibrary(this);
	}
	
	/** prompt to quit view screen
	 * 
	 */
	public void promptForView()
	{
		this.view();
		String quit = DisplayMenu.promptForView();
		if (quit.equalsIgnoreCase("q"))
		{
			processBooksLibrary(this);
		}
	}
	
	/** print to file
	 * 
	 */
	public void print() {
		File fileOutput = FileAccess.getFile(FILE_NAME);
		FileAccess.writeToFile(fileOutput, book.print());
	}
	
	/** view book array data
	 * 
	 */
	public void view()
	{
		booksLibrary = new ArrayList<Media>();
		
		//create/get file reference for filename
		File booksFile = FileAccess.getFile(FILE_NAME);
		if (booksFile != null)
		{
			List<String> fileData = FileAccess.readFromFile(booksFile);
			createBookFromFileData(fileData);
		}
		
		// print header
		System.out.printf("%-35s %-35s %-10s %-20s\n", "Title", "Author", "Format", "ISBN");
		System.out.printf("%-80s\n", "------------------------------------------------------------------------------------------------");
		
		for (Media item : booksLibrary)
		{
			System.out.printf("%-35s %-35s %-10s %-20s\n", item.getTitleName(), ((Book)item).getAuthorName(), item.getFormat(), ((Book)item).getIsbn());
		}
		
	}

	/** create the book object from the file data retrieved
	 * 
	 * @param fileData
	 */
	private void createBookFromFileData(List<String> fileData) {
		for (String line : fileData)
		{
			try {
				String[] elements = Library.parseLineToElementsArray(line);
				Book book = new Book();
				book.setTitleName(elements[0]);
				book.setAuthorName(elements[1]);
				book.setFormat(elements[2]);
				book.setIsbn(elements[3]);
				booksLibrary.add(book);
			}catch (IndexOutOfBoundsException outOfBounds)
			{
				System.out.println("Cannot get data at index, out of bounds.");
			}
		}
	}


	/** return book object
	 * 
	 * @return
	 */
	public Book getBook() {
		return book;
	}


	/** return bookslibrary object
	 * 
	 * @return
	 */
	public List<Media> getBooksLibrary() {
		return booksLibrary;
	}
	
	
	
}
