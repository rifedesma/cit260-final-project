

/** Displays menus 
 * 
 * @author Purnell Darrell and Desma Rife
 *
 */
public class DisplayMenu {

		
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
		
		promptForTitle(book);

		promptForBookAuthor(book);
		
		promptFormatItem(book);
			
		promptForBookISBN(book);
		
		((BooksLibrary)library).print();
	}
	
	/** prompt for ISBN and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForBookISBN(Book book) {
		
		while (book.getIsbn() == null || (book.getIsbn() != null && book.getIsbn().equals("")))
		{
			
			String isbn = PromptUser.promptForLine("ISBN: ");
			if (isbn.equals(""))
			{
				System.out.println("ISBN cannot be blank.");
				
			}else
			{
				book.setIsbn(isbn);
			}
		}	
	}
	
	/** prompt for author and saved to book object
	 * 
	 * @param book
	 */
	private static void promptForBookAuthor(Book book) {
		
		while (book.getAuthorName() == null || (book.getAuthorName() != null && book.getAuthorName().equals("")))
		{
			
			String author = PromptUser.promptForLine("Author name: ");
			if (author.equals(""))
			{
				System.out.println("Author cannot be blank.");
				
			}else
			{
				book.setAuthorName(author);
			}
		}	
	}
	
	
	/** prompt for title and saved to Media object
	 * 
	 * @param book
	 */
	private static void promptForTitle(Media media) {
		
		while (media.getTitleName() == null || (media.getTitleName() != null && media.getTitleName().equals("")))
		{
			
			String title = PromptUser.promptForLine("Title name: ");
			if (title.equals(""))
			{
				System.out.println("Title cannot be blank.");
				
			}else 
			{
				media.setTitleName(title);
			}
		}
	}

	/** prompt for format item and saved to Media object
	 * 
	 * @param book
	 */
	private static void promptFormatItem(Media media) {
		
		while (media.getFormat() == null || (media.getFormat() != null && media.getFormat().equals("")))
		{
			String format = "";
			if (media instanceof Book)
			{
				//System.out.print("format (Hard, Soft, Audio): ");
				format = PromptUser.promptForString("format (Hard, Soft, Audio): ");
			} else if (media instanceof Movies)
			{
				//System.out.print("format (VHS, DVD, Blueray): ");
				format = PromptUser.promptForString("format (VHS, DVD, Blueray): ");
			} else if (media instanceof Music)
			{
				//System.out.print("format (MP3, Wav, Ogg): ");
				format = PromptUser.promptForString("format (MP3, Wav, Ogg): ");
			}
			
			if (media instanceof Book && (!format.equalsIgnoreCase("hard") && 
					!format.equalsIgnoreCase("soft") &&
					!format.equalsIgnoreCase("audio")))
			{
				System.out.println("Format must be either 'Hard, Soft or Audio'.");
				//promptFormatItem(media);
			} else if (media instanceof Movies && (!format.equalsIgnoreCase("vhs") &&
					 !format.equalsIgnoreCase("dvd") && !format.equalsIgnoreCase("blueray")))
			{
				System.out.println("Format must be either 'VHS, DVD or Blueray'.");
				//promptFormatItem(media);
			} else if (media instanceof Music && (!format.equalsIgnoreCase("MP3") &&
					  !format.equalsIgnoreCase("Wav") && !format.equalsIgnoreCase("Ogg")))
			{
				System.out.println("Format must be either 'MP3, Wav or Ogg'.");
				//promptFormatItem(media);
			} else
			{
				
				media.setFormat(format);
			}
		}
			
	}
	
		
	/** prompt for movie entries
     * 
     * @param movie, library
     */
    public static void promptForMovieEntry(Movies movie, Library library)
    {
        System.out.println("Movie");
        System.out.println("");
        
        promptForTitle(movie);

        promptForMovieRating(movie);
        
        promptFormatItem(movie);
        
        ((MoviesLibrary)library).print();
    }
    
    /** prompt for movie rating
     * 
     * @param movie
     */
    public static void promptForMovieRating(Movies movie) 
    {
	    while (movie.getRating() == null || (movie.getRating() != null && movie.getRating().equals(""))) 
	    {
    		
	        String rating = PromptUser.promptForString("Movie Rating (G, PG, PG13, R): ");
	        if (!rating.equalsIgnoreCase("R") && !rating.equalsIgnoreCase("PG13") && !rating.equalsIgnoreCase("PG") && !rating.equalsIgnoreCase("G"))
	        {    
		        System.out.println("Not a valid rating. Must be: G, PG, PG13, or R");        
	        }else 
	            movie.setRating(rating);
	    }
    }
    
    /** prompt for music entries
     * 
     * @param movie
     */
    public static void promptForMusicEntry(Music music, Library library)
    {
        System.out.println("Music");
        System.out.println("");
        
        promptForTitle(music);

        promptForMusicArtist(music);
        
        promptFormatItem(music);
        
        ((MusicLibrary)library).print();
    }
    
    /** prompt for music artist
     * 
     * @param music
     */
    public static void promptForMusicArtist(Music music) 
    {
    	while (music.getArtistName() == null || (music.getArtistName() != null && music.getArtistName().equals("")))
    	{
	        String artist = PromptUser.promptForLine("Artist name: ");
	        if (artist.equals(""))
	        {
	            System.out.println("Artist's name cannot be blank.");
	           
	        }else 
	        {
	            music.setArtistName(artist);
	        }
    	}
    }

    /** leave the media instruction's view
     * 
     */
	public static String promptForView()
	{
		String quit = "";
		while (quit.equals("") || !quit.equalsIgnoreCase("q"))
		{
		
			System.out.println("");
			
			quit = PromptUser.promptForString("Enter 'q' to go back to options menu: ");
			if (!quit.equalsIgnoreCase("q"))
			{
				System.out.print("Must enter 'q' to go back.");
				
			}
		
		}
		return quit;
	}

}
