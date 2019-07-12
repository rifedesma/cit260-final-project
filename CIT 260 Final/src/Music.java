

public class Music extends Media{

    private String artist;
    private String isbn;
    
    Music() 
    {
        
    }
    
    Music(String title, String artist, String isbn, String format) {
        super(title, format);
        
        this.artist = artist;
        this.isbn = isbn;
    }
    
    void setArtistName(String artist)
    {
        this.artist = artist;
    }
    
    String getArtistName()
    {
        return this.artist;
    }
    
    void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    
    String getIsbn()
    {
        return this.isbn;
    }
    
    public String print()
    {
        return super.getTitleName() +"|" + this.artist + "|" + super.getFormat().toUpperCase() + "|" + this.isbn + "\n";
    }
}
