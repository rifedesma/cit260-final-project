import java.util.ArrayList;
import java.util.List;

/** Creates BooksLibrary object
 * 
 * @author Purnell Darrell
 *
 */
public class BooksLibrary extends Library {

	private static final String filename = "Books.txt";
	private List<Book> booksLibrary = null;
	private Book book = null;
	
	public BooksLibrary()
	{
		super();
	}
	
	/** prompt for Book entry fields
	 * 
	 */
	public void promptForEntry()
	{
		book = new Book();
		DisplayMenu.promptForEntry(book);
		processBookLibrary(this);
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
			processBookLibrary(this);
		}
	}
	
	/** print to file
	 * 
	 */
	public void print() {
		book.print();
	}
	
	/** view book array data
	 * 
	 */
	public void view()
	{
		booksLibrary = new ArrayList<Book>();
		
		System.out.printf("%-35s %-35s %-10s %-20s\n", "Title", "Author", "Format", "ISBN");
		
	}


	public Book getBook() {
		return book;
	}




	public List<Book> getBooksLibrary() {
		return booksLibrary;
	}
	
	
	
}
