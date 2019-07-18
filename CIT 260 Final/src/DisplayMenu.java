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
	
	
	public static void promptForBookEntry(Book book, Library library)
	{
		System.out.println("Book");
		System.out.println("");
		promptForBookTitle(book);

		promptForBookAuthor(book);
		
		promptBookFormatItem(book);
			
		promptForBookISBN(book);
		
		((BooksLibrary)library).print();
	}

	/** prompt for ISBN and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForBookISBN(Book book) {
		System.out.print("ISBN: ");
		String isbn = input.nextLine();
		if (isbn.equals(""))
		{
			System.out.println("ISBN cannot be blank.");
			input.hasNextLine();
			promptForBookISBN(book);
		}else
		{
			book.setIsbn(isbn);
		}
	}

	/** prompt for author and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForBookAuthor(Book book) {
		System.out.print("Author name: ");
		String author = input.nextLine();
		if (author.equals(""))
		{
			System.out.println("Author cannot be blank.");
			input.hasNextLine();
			promptForBookAuthor(book);
		}else
		{
			book.setAuthorName(author);
		}
	}

	/** prompt for title and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForBookTitle(Book book) {
		System.out.print("Title name: ");
		String title = input.nextLine();
		if (title.equals(""))
		{
			System.out.println("Title cannot be blank.");
			input.hasNextLine();
			promptForBookTitle(book);
		}else 
		{
			book.setTitleName(title);
		}
	}

	/** prompt for format item and saved to book object
	 * 
	 * @param book
	 */
	private static void promptBookFormatItem(Book book) {
		System.out.print("format (Hard, Soft, Audio): ");
		String format = input.nextLine();
		if (!format.equalsIgnoreCase("hard") && 
				!format.equalsIgnoreCase("soft") &&
				!format.equalsIgnoreCase("audio"))
		{
			System.out.println("Format must be either 'Hard, Soft or Audio'.");
			promptBookFormatItem(book);
		}else
		{
			
			book.setFormat(format);
		}
	}
	
	/** leave the media instruction's view
     * 
     */
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
	
	/** prompt for movie entries
     * 
     * @param movie, library
     */
    public static void promptForMovieEntry(Movies movie, Library library)
    {
        System.out.println("Movie");
        System.out.println("");
        
        promptForMovieTitle(movie);

        promptForMovieRating(movie);
        
        promptMovieFormat(movie);
        
        ((MoviesLibrary)library).print();
    }
    
    /** prompt for movie title
     * 
     * @param movie
     */
    public static void promptForMovieTitle(Movies movie) 
    {
        System.out.print("Title name: ");
        String title = input.nextLine();
        if (title.equals(""))
        {
            System.out.println("Title cannot be blank.");
            input.hasNextLine();
            promptForMovieTitle(movie);
        }else 
        {
            movie.setTitleName(title);
        }
    }
    
    /** prompt for movie rating
     * 
     * @param movie
     */
    public static void promptForMovieRating(Movies movie) 
    {
        System.out.print("Movie Rating: ");
        String title = input.nextLine();
        if (title.equals(""))
        {
            System.out.println("Rating cannot be blank.");
            input.hasNextLine();
            promptForMovieTitle(movie);
        }else 
        {
            movie.setRating(title);
        }
    }

    /** prompt for music entries
     * 
     * @param movie
     */
    public static void promptMovieFormat(Movies movie) 
    {
        System.out.print("format (VHS, DVD, Blueray): ");
        String format = input.nextLine();
        if (!format.equalsIgnoreCase("vhs") && 
                !format.equalsIgnoreCase("dvd") &&
                !format.equalsIgnoreCase("blueray"))
        {
            System.out.println("Format must be either 'VHS, DVD or Blueray'.");
            promptMovieFormat(movie);
        }else
        {
            
            movie.setFormat(format);
        }
    }
    

    /** prompt for movie rating
     * 
     * @param music, library
     */
    public static void promptForMusicEntry(Music music, Library library)
    {
        System.out.println("Music");
        System.out.println("");
        promptForMusicTitle(music);

        promptForMusicArtist(music);
        
        promptMusicFormat(music);
        
        ((MusicLibrary)library).print();
    }

    /** prompt for music title
     * 
     * @param music
     */
    public static void promptForMusicTitle(Music music) 
    {
        System.out.print("Title name: ");
        String title = input.nextLine();
        if (title.equals(""))
        {
            System.out.println("Title cannot be blank.");
            input.hasNextLine();
            promptForMusicTitle(music);
        }else 
        {
            music.setTitleName(title);
        }
    }

    /** prompt for music artist
     * 
     * @param music
     */
    public static void promptForMusicArtist(Music music) 
    {
        System.out.print("Artist name: ");
        String artist = input.nextLine();
        if (artist.equals(""))
        {
            System.out.println("Artist's name cannot be blank.");
            input.hasNextLine();
            promptForMusicArtist(music);
        }else 
        {
            music.setArtistName(artist);
        }
    }

    /** prompt for music format
     * 
     * @param music
     */
    public static void promptMusicFormat(Music music) 
    {
        System.out.print("format (MP3, Wav, Ogg): ");
        String format = input.nextLine();
        if (!format.equalsIgnoreCase("MP3") && 
                !format.equalsIgnoreCase("Wav") &&
                !format.equalsIgnoreCase("Ogg"))
        {
            System.out.println("Format must be either 'MP3, Wav or Ogg'.");
            promptMusicFormat(music);
        }else
        {
            music.setFormat(format);
        }
    }
    
}
