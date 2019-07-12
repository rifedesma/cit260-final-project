
public class Movies extends Media{
    private String rating;
    
    Movies() 
    {
        
    }
    
    Movies(String title, String rating, String format) {
        super(title, format);
        
        this.rating = rating;
    }
    
    void setRating(String rating)
    {
        this.rating = rating;
    }
    
    String getRating()
    {
        return this.rating;
    }
    
    public String print()
    {
        return super.getTitleName() +"|" + this.rating + "|" + super.getFormat().toUpperCase() + "\n";
    }
}
