package lab2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Lab2 {

	public static void main(String[] args) throws IOException {
		
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Type filename: ");
		String input = s.nextLine();
		File f = new File(input);
		
		
		while(f.exists() == false) {
			System.out.println("File not found \n Type filename: ");
			input = s.nextLine();
			f = new File(input);
			if (f .exists() == true) {
				System.out.println("File exists");
				break;
			}
		}
		
		//vad händer?????
		FileReader reader = new FileReader(input);
		BufferedReader buffer = new BufferedReader(reader);
		Scanner c = new Scanner(reader);
		StringBuilder builder = new StringBuilder();
		
		while(c.hasNextLine()) {
			String lines = c.nextLine().trim();
			if(!lines.isEmpty()) {
				builder.append(lines).append(" ");
			}
		}
		
		c.close();
		String st = builder.toString().trim();
		st = st.toLowerCase();
		
		String [] result = st.split(" +");
		Dictionary d = new Dictionary();
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(d.addString(result[i]));
		}
		System.out.println("\n");
		
        // Sort by bycounts 
        System.out.println(d.sortList(2).toString() + d.toString());

        //Sort by byname            
        System.out.println(d.sortList(1).toString() + d.toString());

        // Sort by the original list          
		System.out.println(d.sortList(0).toString() + d.toString());
        
}
}
	