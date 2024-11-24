// TODO: Step 2 - Import file input statements here
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		// //TEST FOR STEP 1 (you can delete/comment this out after completing step 1)
		// Plant test = new Plant("Stinging Nettle,65,anti-inflammatory and culinary");
		// System.out.println("test plant:\n" + test + "\n\n");

		ArrayList<Plant> plants = new ArrayList<>();
		//TODO: Step 2 - Declare + initialize variables for file input here
		Scanner fileScanner = null;
		//TODO: Step 2 - Connect input stream to file (dont forget the try/catch!)
		try {
				fileScanner = new Scanner(new FileInputStream("Forage.csv"));
		//TODO: Step 2 - create loop to read through whole file
				while (fileScanner.hasNextLine()) {
						String line = fileScanner.nextLine();
						try {
							//TODO: Step 3 - build Plant Objects and store into ArrayList
								Plant plant = new Plant(line);
								plants.add(plant);
						} catch (IllegalArgumentException e) {
								System.err.println("Error processing line: " + line);
								System.err.println(e.getMessage());
						}
				}
		} catch (FileNotFoundException e) {
				System.err.println("File not found: Forage.csv");
		} finally {

		//TODO: Step 2 - close the input stream

				if (fileScanner != null) {
						fileScanner.close();
				}
		}
		//TODO: Step 3 - print contents of ArrayList
		System.out.println("Plants loaded from file:");
		for (Plant plant : plants) {
				System.out.println(plant);
				System.out.println("----------------------------");
		}
			}
}