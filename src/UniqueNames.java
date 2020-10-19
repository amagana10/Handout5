import acm.program.*;
import java.util.*;
public class UniqueNames extends ConsoleProgram {
	 public void run() {
		 Map<String,Integer> map = new HashMap<String,Integer>();
		 String name = readLine("Enter name: ");
		 while (!(name.equals(""))) {
			 map.put(name, 1);
			 name = readLine("Enter name: ");
		 }
		
		 println("Unique name list contains:");
		 for(String uName : map.keySet()) {
			 println(uName);
		 }
	 }
} 
