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
	
	/** display and prompt for the libraries menu
	 * 
	 * @return
	 */
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
	
	/** display and prompt for the entry or view options menu 
	 * 
	 * @return
	 */
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
	
	/** prompt for the entry screen of a book
	 * 
	 * @param book
	 * @param library
	 */
	public static void promptForBookEntry(Book book, Library library)
	{
		System.out.println("Book");
		System.out.println("");
		
		book.setTitleName(PromptUser.promptForString("Title: "));
		
		book.setAuthorName(PromptUser.promptForString("Author Name: "));
		
		String format = PromptUser.promptForString("Format (Hard, Soft, Audio): ");
		while (!format.equalsIgnoreCase("hard") && !format.equalsIgnoreCase("soft") && !format.equalsIgnoreCase("audio")) {
		    System.out.println("Invalid book format: " + format);
            format = PromptUser.promptForString("Format (Hard, Soft, Audio): ");
		}
		book.setFormat(format);
			
		book.setIsbn(PromptUser.promptForString("ISBN: "));
		
		((BooksLibrary)library).print();
	}
	
	/** prompt for movie entries
     * 
     * @param movie, library
     */
    public static void promptForMovieEntry(Movies movie, Library library)
    {
        System.out.println("Movie");
        System.out.println("");
        
        movie.setTitleName(PromptUser.promptForString("Title: "));

        String rating= PromptUser.promptForString("Rating (G, PG, PG13, R): ");
        while (!rating.equals("G") && !rating.equals("PG") && !rating.equals("PG13") && !rating.equals("R")) {
            System.out.println("Invalid movie rating: " + rating);
            rating = PromptUser.promptForString("Rating (G, PG, PG13, R): ");
        }
        movie.setRating(rating);
        
        String format= PromptUser.promptForString("Format (VHS, DVD, Blueray: ");
        while (!format.equals("VHS") && !format.equals("DVD") && !format.equals("Blueray")) {
            System.out.println("Invalid movie format: " + format);
            format = PromptUser.promptForString("Format (VHS, DVD, Blueray: ");
        }
        movie.setFormat(format);
        
        ((MoviesLibrary)library).print();
    }
    

    /** prompt for movie rating
     * 
     * @param music, library
     */
    public static void promptForMusicEntry(Music music, Library library)
    {
        System.out.println("Music");
        System.out.println("");
        
        music.setTitleName(PromptUser.promptForString("Title: "));

        music.setArtistName(PromptUser.promptForString("Artist Name: "));
        
        String format = PromptUser.promptForString("Format (MP3, Wav, Ogg: ");
        while (!format.equals("MP3") && !format.equals("Wav") && !format.equals("Ogg")) {
            System.out.println("Invalid music format: " + format);
            format = PromptUser.promptForString("Format (MP3, Wav, Ogg: ");
        }
        music.setFormat(format);
        
        ((MusicLibrary)library).print();
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

}
