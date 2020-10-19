
import acm.program.*;
import java.io.*;
public class WordCount extends ConsoleProgram {
	public void run() {
		 int lines = 0;
		 int words = 0;
		 int chars = 0;
		 
		 try (BufferedReader rd = openFileReader()) {
			 String line = rd.readLine();
			 while (line != null) {
				 lines++;
				 words += countWords(line);
				 chars += line.length();
				 line = rd.readLine();
			 }
		 } catch (IOException ex) {
		 println("An I/O exception has occurred");
		 }
		 
		 println("Lines = " + lines);
		 println("Words = " + words);
		 println("Chars = " + chars);
	 }
 
 	private BufferedReader openFileReader() {
		 BufferedReader reader = null;
		 while (reader == null) {
		 String fileName = readLine("File name: ");
		 try {
			 reader = new BufferedReader(new FileReader(fileName));
		 } catch (IOException e) {
			 println("No file found.");
		 }
		 }
		 return reader;
 } 
 	private int countWords(String line) {
		 boolean inWord = false;
		 int numOfWords = 0;
		 for (int i = 0; i < line.length(); i++) {
			 char ch = line.charAt(i);
			 if (Character.isLetterOrDigit(ch)) {
				 inWord = true;
			 } else {
				 if (inWord) {
					 numOfWords++;
				 } 
				 inWord = false;
			 }
		 }
		 
		 if (inWord) {
			 numOfWords++;
		 }
		 return numOfWords;
	 }
} 

