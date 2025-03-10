package lab2;

public class Word {
	
	public static final int ORIGINAL = 0, BYNAME = 1, BYCOUNTS = 2;
	private String theWord;
	private int count;
	private static int sortCriterion = ORIGINAL;
	
	
	
	public Word (String a, int b) {
		theWord = a;
		count = b;
	}
	
	
	public int getCount() {
		return count;
	}
	
	
	public String getWord() {
		return theWord;
	}
	
	
	public static void setCriterion(int arg) {

		if((arg ==ORIGINAL) || (arg == BYNAME) ||arg == BYCOUNTS) {
			sortCriterion = arg;
		}
	}
	
	
	public int compareTo(Word arg) {
		
		if(sortCriterion == ORIGINAL) {
			return 2;
		}
		else if (sortCriterion == BYNAME) {			
			return theWord.compareTo(arg.theWord);
		}
		else if (sortCriterion == BYCOUNTS) {
			if (count < arg.count) {		
				return -1;
			}
			else if (count == arg.count) {				
				return 0;
			}
			else {				
				return 1;
			}
		}
		return 0;
	}
	
	
	public String toString() {
		return String.format("Word: %10s %3s Count: %10d", theWord, " ", count + "\n");
	}
	
	
}