
public class Book extends Media {

	private String authorName = "";
	private String isbn = "";
	
	public Book() {
		super();
	}

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

	
	public void print()
	{
		
	}
	
	public String toString()
	{
		return null;
	}
	
}
