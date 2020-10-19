import acm.program.*;
import acm.util.*;
import java.io.*;
public class Histograms extends ConsoleProgram {
	 private int[] histogramArray;

	 public void run() {
		 initHistogram();
		 readScoresIntoHistogram();
		 printHistogram();
	 }
	 private void initHistogram() {
		 histogramArray = new int[11];
		 for (int i = 0; i <= 10; i++) {
			 histogramArray[i] = 0;
		 }
	 } 
	 
	 private void readScoresIntoHistogram() {
		 try {
			 BufferedReader rd
			 = new BufferedReader(new FileReader("MidtermScores.txt"));
			 String line = rd.readLine();
			 while (line != null) {
				 int score = Integer.parseInt(line);
				 if (score < 0 || score > 100) {
					 throw new ErrorException("That score is out of range");
				 } else {
					 int range = score / 10;
					 histogramArray[range]++;
				 }
				 line = rd.readLine();
			 }
		 } catch (IOException ex) {
		 throw new ErrorException(ex);
		 }
	 }
	 private void printHistogram() {
		 for (int range = 0; range <= 10; range++) {
			 String label;
			 if (range == 10) {
				 label = "  100";
			 }else {
				 label = range + "0-" + range + "9";
			 }
			 String stars = createStars(histogramArray[range]);
			 println(label + ": " + stars);
		 }
	 }
	 private String createStars(int n) {
		 String stars = "";
		 for (int i = 0; i < n; i++) {
		 stars += "*";
		 }
		 return stars;
	 }
} 