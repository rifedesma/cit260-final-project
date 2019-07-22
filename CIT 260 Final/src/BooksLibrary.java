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
		//display entry/view screen
		int entryViewNumber = DisplayMenu.displayAndPromptEntryViewMenu();
		
		// if option number is between 1-4 ok else error message
		if (entryViewNumber <= 0 || entryViewNumber >= 4)
		{
			System.out.println("Must enter a valid option number.");
			processBooksLibrary(libraryObj);
		}
		
		//select the option number and call appropriate method
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
	@Override
	public void promptForEntry()
	{
		//prompt for entry of book
		book = new Book();
		DisplayMenu.promptForBookEntry(book, this);
		processBooksLibrary(this);
	}
	
	/** prompt to quit view screen
	 * 
	 */
	@Override
	public void promptForView()
	{
		//prompt view screen quit message
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
	@Override
	public void print() {
		//output to the book file a book record
		File fileOutput = FileAccess.getFile(FILE_NAME);
		FileAccess.writeToFile(fileOutput, book.print());
	}
	
	/** view book array data
	 * 
	 */
	@Override
	public void view()
	{
		//initialize booksLibrary
		
		booksLibrary = new ArrayList<Media>();
		
		//create/get file reference for filename
		File booksFile = FileAccess.getFile(FILE_NAME);
		if (booksFile != null)
		{
			//read file
			List<String> fileData = FileAccess.readFromFile(booksFile);
			//create bookslibrary data
			createBookFromFileData(fileData);
		}
		
		// print header
		System.out.printf("%-35s %-35s %-10s %-20s\n", "Title", "Author", "Format", "ISBN");
		System.out.printf("%-80s\n", "------------------------------------------------------------------------------------------------");
		
		// loop through bookslibrary and print to screen
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
		// loop through filedata and create book object
		// catch outofbounds error
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
		//return book object
		return book;
	}


	/** return bookslibrary object
	 * 
	 * @return
	 */
	public List<Media> getBooksLibrary() {
		//return bookslibrary list
		return booksLibrary;
	}
	
	
	
}
