package lab6;

import java.util.ArrayList;
import java.io.*;

public class PhoneBook {
	
	private ArrayList<Person> listOfNumbers;
	
	public PhoneBook() {
		
		listOfNumbers = new ArrayList<Person>();
	}
	
	public String load(String arg) throws IOException {
		
		File file = new File (arg);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String[] person;
			String personline;
			int number;
			while((personline = br.readLine()) != null) {
				 person = personline.split(" +"); //+ because there is more than one split
				 number = Integer.parseInt(person[2]);
				 Person newp = new Person(person[0], person[1], number);
				listOfNumbers.add(newp);
			}
			fr.close();
			br.close();
			return "Phone book loaded";
			
		} catch (FileNotFoundException e) {
			return "Try again";
		}		
		
		
	}
	
	public ArrayList<Person> search(String arg) {
		ArrayList<Person> search = new ArrayList<Person>();
		
		try {int n = Integer.valueOf(arg); //skillnad mellan den och Integer.parseInt
			for(int i = 0; i <listOfNumbers.size(); i++){
				if(listOfNumbers.get(i).getPhoneNumber() == n) search.add(listOfNumbers.get(i));
			}
		} catch (NumberFormatException ierr) {
			for(int i = 0; i <listOfNumbers.size(); i++){
				if(listOfNumbers.get(i).getSurname().equals(arg)) search.add(listOfNumbers.get(i));
			}
		}
		
		
	
		return search;
	}
	
	public String deletePerson(String arg1, int arg2) {
	
		//???????????????????????????????????
		ArrayList<Person> temp = search(String.valueOf(arg2).trim());
		
		if(temp.size()==0) {
			return "The person/number does not exist";
		}
		else if (temp.size() > 1) {
			return "More than one person";
		}
		
		//måste man ha trim
		else {
			if(temp.get(0).getFullName().equals(arg1.trim())) {
				listOfNumbers.remove(temp.get(0));
				return "Person deleted";
			}
			else {
				return "The person/number does not exist";
			}
		}
		
		
		
		
	}
	
	//??????????????????????????????
	public boolean addPerson(String arg1, int arg2) {
		
		ArrayList<Person> temp = search(String.valueOf(arg2));
		String[] s = arg1.split(" ");
		
		
		if (temp.size() == 0 &&  s.length==2) {
			listOfNumbers.add(new Person(s[0], s[1], arg2));
			return true;
		}
		
		
		return false;
	}
	
	public String save(String arg) throws IOException {
		
		File f = new File(arg);
		f.createNewFile();	
		String output;
		
		BufferedWriter w = new BufferedWriter(new FileWriter(f)); //true or false?
		
		for (int i = 0; i < listOfNumbers.size(); i++) {
			Person p = listOfNumbers.get(i);
			output = String.format("%-20s %-5d", p.getFullName(), p.getPhoneNumber());
			w.write(output);
			w.newLine();
		}
		w.close(); //be outside of the loop 
		
		return "Saved " + listOfNumbers.size() + " people to the file";
	}

}
