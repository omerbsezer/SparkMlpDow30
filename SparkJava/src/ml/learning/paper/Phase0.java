package ml.learning.paper;

import java.io.File;
import java.io.PrintWriter;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class Phase0 {

	public static void main(String[] args) throws Exception  {
		String strpath="resources/APPL19972007.csv";
		//String strpath="resources/APPL20072017.csv";

		ReversedLinesFileReader fr = new ReversedLinesFileReader(new File(strpath));
		String ch;
		int time=0;
		String Conversion="";

		PrintWriter writer = new PrintWriter("resources/reverseFile.csv", "UTF-8");

		do {
			ch = fr.readLine();
			System.out.println(ch);
			if(ch != null)
				writer.println(ch);

		} while (ch != null);
		writer.close();
		fr.close();
	}
}
