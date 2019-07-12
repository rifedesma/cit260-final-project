import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicLibrary extends Library{
    private static final String FILE_NAME = "Music.txt";
    private List<Media> musicLibrary = null;
    private Music music = null;
    
    public void processMusicLibrary(Library libraryObj)
    {
        int entryViewNumber = DisplayMenu.displayAndPromptEntryViewMenu();
        
        if (entryViewNumber <= 0 || entryViewNumber >= 4)
        {
            System.out.println("Must enter a valid option number.");
            processMusicLibrary(libraryObj);
        }
        
        if (entryViewNumber == 1)
        {
            ((MusicLibrary)libraryObj).promptForEntry();
        } else if (entryViewNumber == 2)
        {
            ((MusicLibrary)libraryObj).promptForView();
        } else
        {
            libraryMenu();
        }
    }
    
    /** prompt for Book entry fields
     * 
     */
    public void promptForEntry()
    {
        music = new Music();
        DisplayMenu.promptForMusicEntry(music, this);
        processMusicLibrary(this);
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
            processMusicLibrary(this);
        }
    }
    
    public void view()
    {
        musicLibrary = new ArrayList<Media>();
        
        //create/get file reference for filename
        File musicFile = FileAccess.getFile(FILE_NAME);
        if (musicFile != null)
        {
            List<String> fileData = FileAccess.readFromFile(musicFile);
            createMusicFromFileData(fileData);
        }
        
        // print header
        System.out.printf("%-35s %-35s %-10s %-20s\n", "Title", "Artist", "Format", "ISBN");
        System.out.printf("%-80s\n", "------------------------------------------------------------------------------------------------");
        
        for (Media item : musicLibrary)
        {
            System.out.printf("%-35s %-35s %-10s %-20s\n", item.getTitleName(), ((Music)item).getArtistName(), item.getFormat(), ((Music)item).getIsbn());
        }
        
    }
    
    private void createMusicFromFileData(List<String> fileData) {
        for (String line : fileData)
        {
            try {
                String[] elements = Library.parseLineToElementsArray(line);
                Music music = new Music();
                music.setTitleName(elements[0]);
                music.setArtistName(elements[1]);
                music.setFormat(elements[2]);
                music.setIsbn(elements[3]);
                musicLibrary.add(music);
            }catch (IndexOutOfBoundsException outOfBounds)
            {
                System.out.println("Cannot get data at index, out of bounds.");
            }
        }
    }
    
    /** print to file
     * 
     */
    public void print() {
        File fileOutput = FileAccess.getFile(FILE_NAME);
        FileAccess.writeToFile(fileOutput, music.print());
    }
}
