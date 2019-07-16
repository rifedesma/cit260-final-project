import java.io.Serializable;

/** Book derived class for entity
 * 
 * @author Purnell Darrell
 *
 */
public class Book extends Media {

	
	private String authorName = "";
	private String isbn = "";
	
	/** default constructor
	 * 
	 */
	public Book() {
		super();
	}

	/** constructor to make full Book entity
	 * 
	 * @param titleName
	 * @param format
	 * @param authorName
	 * @param isbn
	 */
	public Book(String titleName, String format, String authorName, String isbn) {
		//set base class properties
		super(titleName, format);
		//set this classes properties
		this.authorName = authorName;
		this.isbn = isbn;

	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/** string for saving to file
	 * 
	 */
	@Override
	public String print()
	{
		return super.getTitleName() +"|" + authorName + "|" + super.getFormat().toUpperCase() + "|" + isbn + "\n";
	}
	
	
	
}
