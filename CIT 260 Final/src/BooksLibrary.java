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
	
	public void promptForEntry()
	{
		book = new Book();
		DisplayMenu.promptForEntry(book);
		processBookLibrary(this);
	}
	
	
	
	
	public void print() {
		book.print();
	}
	
	public void view()
	{
		booksLibrary = new ArrayList<Book>();
		
	}


	public Book getBook() {
		return book;
	}




	public List<Book> getBooksLibrary() {
		return booksLibrary;
	}
	
	
	
}
