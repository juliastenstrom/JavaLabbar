package lab22;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Dictionairy {
private ArrayList<Word> thelist;
private ArrayList<Word> backup = null;

public Dictionairy() {
	
	thelist = new ArrayList<Word>();
}

public String addString(String arg) {
	Word w = null;

	for (int i = 0; i < thelist.size(); i++) {
	    if (thelist.get(i).getWord().equals(arg)) {
	        w = thelist.get(i);
	        w = new Word(arg, w.getCount() + 1);
	        thelist.set(i,w);
	    }
	    
	    try {
	    	double d = Double.parseDouble(thelist.get(i).getWord());
	    	thelist.remove(i);
	    }catch(NumberFormatException ex){
	    	;
	    }
	}
	if (w == null) {
	    w = new Word(arg, 1);
	    thelist.add(w);
	}
	return w.toString();
}

public String sortList(int arg) {
	String returner = new String();
	
	if (backup == null) {
		backup = new ArrayList<Word>(thelist.size());
		
		for (int i = 0; i<thelist.size();i++) {
			Word w = new Word(thelist.get(i).getWord(), thelist.get(i).getCount());
			backup.add(i, w);
		}
	}	
	
	if (arg == Word.ORIGINAL) {
		Word.setCriterion(Word.ORIGINAL);
		thelist = backup;
		returner = ("Word list was reset\n");
	}
	
	if(arg == Word.BYCOUNTS || arg == Word.BYNAME) {
		
		Word.setCriterion(arg);
		
		//sorting stuff
	    boolean swapped;

	    for (int i = 0; i < thelist.size() - 1; i++) {
	        swapped = false;

	        for (int j = 0; j < thelist.size() - i - 1; j++) {
	            if (thelist.get(j).compareTo(thelist.get(j + 1)) > 0) {
	                // swap 
	                Word temp = thelist.get(j);
	                thelist.set(j, thelist.get(j + 1));
	                thelist.set(j + 1, temp);
	                swapped = true;
	            }
	        }
	        if (!swapped) {
	            break;
	        }
	    }
	}	
	
	if (arg == Word.BYCOUNTS){
		returner = ("Sorted by counts\n");
	}
	else if (arg == Word.BYNAME){
		returner = ("Sorted alphabetically\n");
	}
	else if (arg != Word.ORIGINAL){
		returner = ("Sort criterion unknown\n");
	}
	
    return returner;
}

public String toString() {
	
	String s = new String("Content:\n");
	StringBuilder builder = new StringBuilder();
	
	for (int i = 0; i < thelist.size(); i++) {
		String addon = thelist.get(i).toString() + "\n";
		builder.append(addon);
	}
	String s2 = new String(s + builder);
	return s2;
}

}
