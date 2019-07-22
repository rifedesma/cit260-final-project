import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** Movies Library 
 * 
 * @author Desma Rife
 *
 */

public class MoviesLibrary extends Library{
    private static final String FILE_NAME = "Movies.txt";
    private List<Media> moviesLibrary = null;
    private Movies movie = null;
    
    public void processMoviesLibrary(Library libraryObj)
    {
        int entryViewNumber = DisplayMenu.displayAndPromptEntryViewMenu();
        
        if (entryViewNumber <= 0 || entryViewNumber >= 4)
        {
            System.out.println("Must enter a valid option number.");
            processMoviesLibrary(libraryObj);
        }
        
        if (entryViewNumber == 1)
        {
            ((MoviesLibrary)libraryObj).promptForEntry();
        } else if (entryViewNumber == 2)
        {
            ((MoviesLibrary)libraryObj).promptForView();
        } else
        {
            libraryMenu();
        }
    }

    /** 
     * Print to console and prompt user for:
     * " Title Name:
     *   Movie Rating:
     *   format (VHS, DVD, Blueray): "
     */
    @Override
    public void promptForEntry()
    {
        movie = new Movies();
        DisplayMenu.promptForMovieEntry(movie, this);
        processMoviesLibrary(this);
    }
    
    /** 
     * Print to console and prompt user for:
     * "Enter 'q' to go back to options menu: "
     */
    @Override
    public void promptForView()
    {
        this.view();
        String quit = DisplayMenu.promptForView();
        if (quit.equalsIgnoreCase("q"))
        {
            processMoviesLibrary(this);
        }
    }
    
    /*
     * Print to console:
     * "Title        Rating        Format
     * ------------------------------------------
     *  Movie Title  Movie Rating  Movie Format    "
     */
    @Override
    public void view()
    {
        moviesLibrary = new ArrayList<Media>();
        
        //create/get file reference for filename
        File moviesFile = FileAccess.getFile(FILE_NAME);
        if (moviesFile != null)
        {
            List<String> fileData = FileAccess.readFromFile(moviesFile);
            createMusicFromFileData(fileData);
        }
        
        // print header
        System.out.printf("%-35s %-35s %-10s\n", "Title", "Rating", "Format");
        System.out.printf("%-80s\n", "------------------------------------------------------------------------------------------------");
        
        for (Media item : moviesLibrary)
        {
            System.out.printf("%-35s %-35s %-10s\n", item.getTitleName(), ((Movies)item).getRating(), item.getFormat());
        }
        
    }
    
    private void createMusicFromFileData(List<String> fileData) {
        for (String line : fileData)
        {
            try {
                String[] elements = Library.parseLineToElementsArray(line);
                Movies movie = new Movies();
                movie.setTitleName(elements[0]);
                movie.setRating(elements[1]);
                movie.setFormat(elements[2]);
                moviesLibrary.add(movie);
            }catch (IndexOutOfBoundsException outOfBounds)
            {
                System.out.println("Cannot get data at index, out of bounds.");
            }
        }
    }
    
    /** print to file
     * 
     */
    @Override
    public void print() {
        File fileOutput = FileAccess.getFile(FILE_NAME);
        FileAccess.writeToFile(fileOutput, movie.print());
    }
}
