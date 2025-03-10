package lab2;
import java.util.ArrayList;
public class Dictionary {

private ArrayList<Word> theList;
private ArrayList<Word> backup = null;
	
	public Dictionary() {
		theList = new ArrayList<Word>();
	}
	
	public String addString(String arg) {
		
		Word newWord = null;
		
		for(int i = 0; i < theList.size(); i++) {
			if(arg.equals(theList.get(i).getWord())) {
				newWord = theList.get(i);
				newWord = new Word(arg, newWord.getCount() + 1);
				theList.set(i, newWord);
				
			}
			
			 /* try {
			    	double de = Double.parseDouble(theList.get(i).getWord());
			    	theList.remove(i);
			    }catch(NumberFormatException ex){
			    	;
			    }*/
		}
		if (newWord == null) {
			newWord = new Word(arg, 1);
			theList.add(newWord);
		}
		return newWord.toString();
	}
	
	public String sortList(int arg) {
		
		String returner = new String();
		if (backup == null) {
			backup = new ArrayList<Word>(theList.size());
			for (int i = 0; i < theList.size(); i++) {
				Word dummy = new Word(theList.get(i).getWord(), theList.get(i).getCount());
				backup.add(i, dummy);	
			}
		}
		
		if(arg == Word.ORIGINAL) {
			Word.setCriterion(Word.ORIGINAL);
			theList = backup;
			returner = "Word list was reset";
		}
		
		if(arg == Word.BYNAME || arg == Word.BYCOUNTS) {
			Word.setCriterion(arg);
			boolean swapped;
			for (int i = 0; i < theList.size() - 1; i++) {
				swapped = false;
				for (int j = 0; j < theList.size() -i - 1; i++) {
					if (theList.get(j).compareTo(theList.get(j+1)) > 0) { 
						Word temp = theList.get(j);
						theList.set(j, theList.get(j + 1));
						theList.set(j + 1,  temp);
						swapped = true;
					}
				}
				if (!swapped) {
					break;
				}
			}			
		}
		
		if(arg == Word.BYCOUNTS) {
			returner = "Sorted by counts\n";
		}else if (arg == Word.BYNAME) {
			returner = "Sorted alphabetically\n";
		}
		else if (arg != Word.ORIGINAL){
		return "Sort criterion not known\n";
		}
	
		return returner;
	}
	
	public String toString() {
		String s = new String ("Content\n");
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < theList.size();i++) {
			String addon = theList.get(i).toString() + "\n";
			result.append(addon);
		}
		String s2 = new String(s + result);
		return s2;
	
	}
	
}