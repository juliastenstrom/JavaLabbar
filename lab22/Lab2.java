package lab22;

import java.io.*;
import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) throws IOException{
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Type filename:");
		String input = s.nextLine();	
		File f = new File(input);
		
		while (f.exists() == false) {
			System.out.println("File not found!\ntype filename:");
			input = s.nextLine();
			f = new File(input);
			if (f.exists() == true) {
				System.out.println("file exists");
				
			}
		}
		
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		
		Scanner scan = new Scanner(br);
		StringBuilder s2 = new StringBuilder();

		while (scan.hasNextLine()) {
		    String line = scan.nextLine().trim(); 
		    if (!line.isEmpty()) {
		        s2.append(line).append(" ");
		    }
		}

		scan.close();
		String s3 = s2.toString().trim();
		s3 = s3.toLowerCase();
		
		String[] result = s3.split(" +");
		Dictionairy dairy = new Dictionairy();
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(dairy.addString(result[i]));
		}
		System.out.println("\n");
		
		System.out.println(dairy.sortList(2)+dairy.toString());
		System.out.println(dairy.sortList(1).toString()+dairy.toString());
		System.out.println(dairy.sortList(0).toString()+dairy.toString());
		
		
		//creating file
		System.out.println("Type filename:");
		String filename = s.nextLine();
		File r = new File(filename); r.createNewFile();
		if (r.exists()==true) {
			System.out.println("file successfully created");
		}
		s.close();
		
		//output to file
		Writer w2 = new BufferedWriter(new FileWriter(r, false));
		w2.write(dairy.sortList(0)+dairy.toString()+"\r\n"); 
		w2.close();
	}
}