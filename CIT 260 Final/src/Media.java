/** Media base class for individual entries
 * 
 * @author Purnell Darrell
 *
 */
public class Media {

	private String titleName = "";
	private String format = "";
	
	/** creates blank Media object
	 * 
	 */
	protected Media()
	{
		
	}
	
	/** created a Media object with specified titleName and format
	 * 
	 * @param titleName
	 * @param format
	 */
	public Media(String titleName, String format)
	{
		this.titleName = titleName;
		this.format = format;
		
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
