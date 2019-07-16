/** Movies Library 
 * 
 * @author Desma Rife
 *
 */

public class Movies extends Media{
    private String rating;
    
    public Movies() 
    {
        super();
    }
    
    public Movies(String title, String rating, String format) {
        super(title, format);
        
        this.rating = rating;
    }
    
    public void setRating(String rating)
    {
        this.rating = rating;
    }
    
    public String getRating()
    {
        return this.rating;
    }
    
    @Override
    public String print()
    {
        return super.getTitleName() +"|" + this.rating + "|" + super.getFormat().toUpperCase() + "\n";
    }
}
