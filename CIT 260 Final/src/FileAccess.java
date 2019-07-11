import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** access file
 * 
 * @author Purnell Darrell
 *
 */
public class FileAccess {

	
	/** retrieve file by filename
	 * 
	 * @param filename
	 * @return
	 */
	public static File getFile(String filename)
	{
		File file = new File(filename);
		if (!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Cannot create file: '" + filename + "'");
			}
		}
		return file;
	}
	
	/** write to specific file
	 * 
	 * @param file
	 */
	public static void writeToFile(File file, String data)
	{
		PrintWriter writer = null;
		try {
			file.setWritable(true);
			if (file.canWrite()) {
				FileWriter fileWriter = new FileWriter(file, true);
				writer = new PrintWriter(fileWriter);
				writer.append(data);
				System.out.println("Data saved successfully.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find specified file: '" + file.getName() + "' for writing.");
		}catch (IOException ioException)
		{
			System.out.println("Cannot open specified file: '" + file.getName() + "' for writing.");
		}
		finally
		{
			if (writer != null)
			{
				writer.close();
			}
		}
	}
	
	public static List<String> readFromFile(File file)
	{
		List<String> lines = new ArrayList<String>();
		if (file.canRead())
		{
			System.out.println("Reading data from '" + file.getName() + "'...");
			Scanner fileInput = null;
			try {
				fileInput = new Scanner(file);
				while (fileInput.hasNextLine())
				{
					lines.add(fileInput.nextLine());
					
				}
			} catch (FileNotFoundException e) {
				System.out.println("Cannot find specified file: '" + file.getName() + "' for reading.");
			}finally
			{
				if (fileInput != null)
				{
					fileInput.close();
				}
			}
			
		}
		return lines;
	}
}
