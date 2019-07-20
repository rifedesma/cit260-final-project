
/** Music 
 * 
 * @author Desma Rife
 *
 */

public class Music extends Media{

    private String artist;
    
    public Music() 
    {
        super();
    }
    
    public Music(String title, String artist, String format) {
        super(title, format);
        
        this.artist = artist;
    }
    
    public void setArtistName(String artist)
    {
        this.artist = artist;
    }
    
    public String getArtistName()
    {
        return this.artist;
    }
    
    /*
     * Print to file "Song Title | Artist's Name | Song's Format"
     */
    @Override
    public String print()
    {
        return super.getTitleName() +"|" + this.artist + "|" + super.getFormat().toUpperCase() + "\n";
    }
}
