import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class findchar {
	public static void main(String[] args) {

		BufferedReader fileReader;
		ArrayList<String> heading = new ArrayList<String>();
		ArrayList<String> theDataG = new ArrayList<String>();
		ArrayList<String> theDataB = new ArrayList<String>();
		try {
			fileReader = new BufferedReader(new FileReader(args[0]));
			String theString = fileReader.readLine();

			long char_count = theString.chars().filter(ch -> ch == ',').count();
			System.out.printf("%s: commas found in the string on the first line %s.\n  This will be the standard.\n  Exceptions to be flagged.\n", char_count, theString);

			heading.add(theString);

			while((theString = fileReader.readLine()) != null) {

				if(char_count == theString.chars().filter(ch -> ch == ',').count()) {
					theDataG.add(theString);
				}
				else {
					theDataB.add(theString);
				}

			}
			System.out.println("Content Header");
			System.out.println(heading);
			System.out.println(theDataG);
			System.out.printf("\n\n\nThe good data has %s records.\n", theDataG.size());
			System.out.println(theDataB);
			System.out.printf("\n\n\nThe bad data has %s records.\n", theDataB.size());

			fileReader.close();

		}
		catch (IOException e) {
			e.printStackTrace();
		}




	}
}

