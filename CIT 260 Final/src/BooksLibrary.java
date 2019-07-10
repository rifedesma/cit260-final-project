import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** Creates BooksLibrary object
 * 
 * @author Purnell Darrell
 *
 */
public class BooksLibrary extends Library {

	private static final String FILE_NAME = "Books.txt";
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
		DisplayMenu.promptForEntry(book, this);
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
		File fileOutput = FileAccess.getFile(FILE_NAME);
		FileAccess.writeToFile(fileOutput, book.print());
	}
	
	/** view book array data
	 * 
	 */
	public void view()
	{
		booksLibrary = new ArrayList<Book>();
		
		File booksFile = FileAccess.getFile(FILE_NAME);
		if (booksFile != null)
		{
			List<String> fileData = FileAccess.readFromFile(booksFile);
			for (String line : fileData)
			{
				try {
					String[] elements = parseLineToElementsArray(line);
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
		
		// print header
		System.out.printf("%-35s %-35s %-10s %-20s\n", "Title", "Author", "Format", "ISBN");
		System.out.printf("%-80s\n", "------------------------------------------------------------------------------------------------");
		
		for (Book item : booksLibrary)
		{
			System.out.printf("%-35s %-35s %-10s %-20s\n", item.getTitleName(), item.getAuthorName(), item.getFormat(), item.getIsbn());
		}
		
	}

	/** parse the line into array of strings
	 * 
	 * @param line
	 * @return
	 */
	private String[] parseLineToElementsArray(String line) {
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


	public Book getBook() {
		return book;
	}




	public List<Book> getBooksLibrary() {
		return booksLibrary;
	}
	
	
	
}
